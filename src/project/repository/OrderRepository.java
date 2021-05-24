package project.repository;
import java.sql.*;
import project.models.*;
import project.database.*;
import project.models.Driver;

import java.sql.Date;
import java.util.*;

public class OrderRepository {
    private static List<Order> registeredOrders = new ArrayList<>();

    //CREATE
    public void insertOrder(Order order) {

        String insertOrder = "INSERT INTO orders (idorder, order_date,delivery_time,iduser,idrestaurant,iddriver) VALUES(?,?,?,?,?,?);";

        java.sql.Date newDate = new java.sql.Date(order.getOrderDate().getTime());
        Connection databaseConnection = DbConfig.getDb();
        try {
            
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertOrder);
            preparedStatement.setInt(1, order.getOrderNumber() );
            preparedStatement.setDate(2, newDate);
            preparedStatement.setInt(3, order.getDeliveryTime());
            preparedStatement.setInt(4, order.getUser().getId());
            preparedStatement.setInt(5, order.getRestaurant().getId());
            preparedStatement.setInt(6, order.getDriver().getEmployeeId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ ALL
    public List<Order> getAllOrders(){
        String select = "SELECT * FROM orders;";
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            mapToOrderList(resultSet, registeredOrders);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredOrders;

    }
    //READ BY ID
    public Order getOrdersById(int id) {
        String select = "SELECT * FROM orders WHERE idorder=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToOrder(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Order mapToOrder(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){

            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUsersById(resultSet.getInt(4));
            RestaurantRepository restaurantRepository = new RestaurantRepository();
            Restaurant restaurant = restaurantRepository.getRestaurantById(resultSet.getInt(5));
            DriverRepository driverRepository = new DriverRepository();
            Driver driver = driverRepository.getDriverById(resultSet.getInt(6));

            return new Order(resultSet.getInt(1), resultSet.getDate(2), resultSet.getInt(3),user,restaurant,driver);
        }
        return null;
    }

    private List<Order> mapToOrderList(ResultSet resultSet, List<Order>registeredOrders) throws SQLException {
        while (resultSet.next()){

            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUsersById(resultSet.getInt(4));
            RestaurantRepository restaurantRepository = new RestaurantRepository();
            Restaurant restaurant = restaurantRepository.getRestaurantById(resultSet.getInt(5));
            DriverRepository driverRepository = new DriverRepository();
            Driver driver = driverRepository.getDriverById(resultSet.getInt(6));
            Order order = new Order(resultSet.getInt(1), resultSet.getDate(2), resultSet.getInt(3),user,restaurant,driver);
            registeredOrders.add(order);

        }
        return registeredOrders;
    }

    //UPDATE order_date
    public void updateOrderDate(Date obj, int id) {
        String update = "UPDATE orders SET order_date=? WHERE idorder=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setDate(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE
    public void updateDeliveryTime(int obj, int id) {
        String update = "UPDATE orders SET delivery_time=? WHERE idorder=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setInt(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    public void  deleteOrdersbyId(int id) {
        String delete = "DELETE FROM orders WHERE idorder=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(delete);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
