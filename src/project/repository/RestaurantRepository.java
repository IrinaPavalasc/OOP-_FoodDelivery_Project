package project.repository;
import java.sql.*;
import project.models.*;
import project.database.*;
import java.util.*;
public class RestaurantRepository {

    private static List<Restaurant> registeredRestaurants = new ArrayList<>();

    //CREATE
    public void insertRestaurant(Restaurant restaurant) {

        String insert = "INSERT INTO restaurants (restaurant_name, restaurant_category,minimum_order, score, city) VALUES(?,?,?,?,?);";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insert);
            preparedStatement.setString(1, restaurant.getRestaurantName());
            preparedStatement.setString(2, restaurant.getCategory());
            preparedStatement.setInt(3, restaurant.getMinimumOrder());
            preparedStatement.setDouble(4, restaurant.getScore());
            preparedStatement.setString(5, restaurant.getCity());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //READ ALL

    public List<Restaurant> getAllRestaurants(){
        String select = "SELECT * FROM restaurants;";
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            mapToRestaurantList(resultSet, registeredRestaurants);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredRestaurants;

    }
    //READ BY ID
    public Restaurant getRestaurantById(int id) {
        String select = "SELECT * FROM restaurants WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToRestaurant(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //UPDATE restaurant_name
    public void updateRestaurantName(String name, int id) {
        String update = "UPDATE restaurants SET restaurant_name=? WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE restaurant_category
    public void updateRestaurantCategory(String category, int id) {
        String update= "UPDATE restaurants SET restaurant_category=? WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, category);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //UPDATE minimum_order
    public void updateRestaurantMinimumOrder(int minimumOrder, int id) {
        String update = "UPDATE restaurants SET minimum_order=? WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setInt(1, minimumOrder);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //UPDATE score
    public void updateRestaurantScore(Double score, int id) {
        String update = "UPDATE restaurants SET score=? WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setDouble(1, score);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //UPDATE city
    public void updateRestaurantCity(String city, int id) {
        String update = "UPDATE restaurants SET city=? WHERE idrestaurant=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Restaurant mapToRestaurant(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Restaurant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5),resultSet.getString(6));
        }
        return null;
    }

    private List<Restaurant> mapToRestaurantList(ResultSet resultSet, List<Restaurant>registeredRestaurants) throws SQLException {
            while (resultSet.next()){
                Restaurant restaurant = new Restaurant(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getDouble(5),resultSet.getString(6));
                registeredRestaurants.add(restaurant);

            }
            return registeredRestaurants;
    }
    //DELETE
    public void  deleteRestaurantbyId(int id) {
        String delete = "DELETE FROM restaurants WHERE idrestaurant=?";

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
