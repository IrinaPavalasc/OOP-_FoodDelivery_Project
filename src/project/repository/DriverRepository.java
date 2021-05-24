package project.repository;
import java.sql.*;
import project.database.*;
import project.models.Driver;

import java.util.*;

public class DriverRepository {
    private static List<Driver> registeredDrivers = new ArrayList<>();

    //CREATE
    public void insertDrivers(Driver driver) {

        String insert= "INSERT INTO drivers  VALUES(?,?,?,?,?,?,?,?,?);";
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insert);
            preparedStatement.setInt(1, driver.getEmployeeId());
            preparedStatement.setString(2, driver.getCarRegistrationNumber());
            preparedStatement.setString(3, driver.getCity());
            preparedStatement.setInt(4, driver.getAverageTime());
            preparedStatement.setString(5, driver.getFirstName());
            preparedStatement.setString(6, driver.getLastName());
            preparedStatement.setString(7, driver.getEmail());
            preparedStatement.setInt(8, driver.getAge());
            preparedStatement.setString(9, driver.getPhoneNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //READ ALL

    public List<Driver> getAllDrivers(){
        String select = "SELECT * FROM drivers;";
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            mapToDriverList(resultSet, registeredDrivers);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredDrivers;

    }
    //READ BY ID
    public Driver getDriverById(int id) {
        String select = "SELECT * FROM drivers WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToDriver(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //UPDATE driver_first_name
    public void updateDriverFirstName(String obj, int id) {
        String update = "UPDATE drivers SET first_name=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //UPDATE driver_last_name
    public void updateDriverLastName(String obj, int id) {
        String update = "UPDATE drivers SET last_name=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE driver_email
    public void updateDriverEmail(String obj, int id) {
        String update = "UPDATE drivers SET email=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE driver_age
    public void updateDriverAge(int obj, int id) {
        String update = "UPDATE drivers SET age=? WHERE idemployee=?";

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

    //UPDATE driver_phone_number
    public void updateDriverPhoneNumber(String obj, int id) {
        String update = "UPDATE drivers SET phone_number=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE driver_car_number
    public void updateDriverCarNumber(String obj, int id) {
        String update = "UPDATE drivers SET car_registration_number=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE driver_city
    public void updateDriverCity(String obj, int id) {
        String update = "UPDATE drivers SET city=? WHERE idemployee=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(update);
            preparedStatement.setString(1, obj);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //UPDATE driver_average_time
    public void updateAverageTime(int obj, int id) {
        String update = "UPDATE drivers SET average_time=? WHERE idemployee=?";

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
    private Driver mapToDriver(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Driver(resultSet.getInt(1), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(2),resultSet.getString(3));
        }
        return null;
    }

    private List<Driver> mapToDriverList(ResultSet resultSet, List<Driver>registeredDrivers) throws SQLException {
        while (resultSet.next()){
            Driver driver = new Driver(resultSet.getInt(1), resultSet.getString(5), resultSet.getString(6),resultSet.getString(7),resultSet.getInt(8),resultSet.getString(9),resultSet.getString(2),resultSet.getString(3));
            registeredDrivers.add(driver);

        }
        return registeredDrivers;
    }
    //DELETE
    public void  deleteDriverbyId(int id) {
        String delete = "DELETE FROM drivers WHERE idemployee=?";

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
