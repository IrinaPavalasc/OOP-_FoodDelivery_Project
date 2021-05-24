package project.repository;
import java.sql.*;
import project.models.*;
import project.database.*;
import java.util.*;
public class UserRepository {
    private static List<User> registeredUsers = new ArrayList<>();

    //CREATE
    public void insertUser(User user) {

        String insertUser = "INSERT INTO users (first_name, last_name,email,age,phone_number, idaddress, idcard) VALUES(?,?,?,?,?,?,?);";
        AddressRepository addressRepository = new AddressRepository();
        int idaddress = addressRepository.insertAddress(user.getAddress());
        CardRepository cardRepository = new CardRepository();
        int idcard = cardRepository.insertCard(user.getCard());

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertUser);
            preparedStatement.setString(1, user.getFirstName() );
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getAge());
            preparedStatement.setString(5, user.getPhoneNumber());
            preparedStatement.setInt(6, idaddress);
            preparedStatement.setInt(7, idcard);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //READ ALL
    public List<User> getAllUsers(){
        String select = "SELECT * FROM users;";
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            mapToUserList(resultSet, registeredUsers);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredUsers;

    }
    //READ BY ID
    public User getUsersById(int id) {
        String select = "SELECT * FROM users WHERE idusers=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToUser(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User mapToUser(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            AddressRepository addressRepository = new AddressRepository();
            Address address = addressRepository.getAddressById(resultSet.getInt(2));
            CardRepository cardRepository = new CardRepository();
            Card card = cardRepository.getCardById(resultSet.getInt(3));
            return new User(resultSet.getInt(1), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8), address, card);
        }
        return null;
    }

    private List<User> mapToUserList(ResultSet resultSet, List<User>registeredUsers) throws SQLException {
        while (resultSet.next()){
            AddressRepository addressRepository = new AddressRepository();
            Address address = addressRepository.getAddressById(resultSet.getInt(2));
            CardRepository cardRepository = new CardRepository();
            Card card = cardRepository.getCardById(resultSet.getInt(3));
            User user = new User(resultSet.getInt(1), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getInt(7),resultSet.getString(8),address,card);
            registeredUsers.add(user);

        }
        return registeredUsers;
    }

    //UPDATE user_first_name
    public void updateUserFirstName(String obj, int id) {
        String update = "UPDATE users SET first_name=? WHERE idusers=?";

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
    //UPDATE user_last_name
    public void updateUserLastName(String obj, int id) {
        String update = "UPDATE users SET last_name=? WHERE idusers=?";

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

    //UPDATE user_email
    public void updateUserEmail(String obj, int id) {
        String update = "UPDATE users SET email=? WHERE idusers=?";

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

    //UPDATE user_age
    public void updateUserAge(int obj, int id) {
        String update = "UPDATE users SET age=? WHERE idusers=?";

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

    //UPDATE user_phone_number
    public void updateUserPhoneNumber(String obj, int id) {
        String update = "UPDATE users SET phone_number=? WHERE idusers=?";

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


    //DELETE
    public void  deleteUserbyId(int id) {
        String delete = "DELETE FROM users WHERE idusers=?";

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
