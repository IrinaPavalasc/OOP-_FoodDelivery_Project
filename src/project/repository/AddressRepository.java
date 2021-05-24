package project.repository;
import java.sql.*;
import project.models.*;
import project.database.*;
public class AddressRepository {

    //CREATE
    public int insertAddress(Address address) {

        String insert= "INSERT INTO address (city,street,number, apartment) VALUES(?,?,?,?);";
        String id = "select idaddress from food_delivery.address order by idaddress desc limit 1";
        int idaddress = 0;
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insert);
            preparedStatement.setString(1,address.getCity() );
            preparedStatement.setString(2,address.getStreet() );
            preparedStatement.setInt(3, address.getNumber());
            preparedStatement.setInt(4, address.getApartment());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                idaddress = resultSet.getInt(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idaddress;
    }
    //READ BY ID
    public Address getAddressById(int id) {
        String select = "SELECT * FROM address WHERE idaddress=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAddress(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Address mapToAddress(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Address(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5));
        }
        return null;
    }
    //UPDATE address_city
    public void updateAddressCity(String obj, int id) {
        String update = "UPDATE address SET city=? WHERE idaddress=?";

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
    //UPDATE address_street
    public void updateAddressStreet(String obj, int id) {
        String update = "UPDATE address SET street=? WHERE iddriver=?";

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
    //UPDATE address_number
    public void updateAddressNumber(int obj, int id) {
        String update = "UPDATE address SET number=? WHERE idaddress=?";

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
    //UPDATE address_apartment
    public void updateAddressApartment(int obj, int id) {
        String update = "UPDATE address SET apartment=? WHERE idaddress=?";

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

}
