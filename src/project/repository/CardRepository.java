package project.repository;
import java.sql.*;
import project.models.*;
import project.database.*;
public class CardRepository {

    //CREATE
    public int insertCard(Card card) {

        String insert= "INSERT INTO cards(card_number, expire_date,security_code) VALUES(?,?,?);";
        String id = "select idcard from food_delivery.cards order by idcard desc limit 1";
        int idcard = 0;
        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insert);
            preparedStatement.setString(1, card.getCardNumber());
            preparedStatement.setString(2, card.getExpireDate());
            preparedStatement.setInt(3, card.getSecurityCode());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                idcard = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idcard;
    }

    //READ BY ID
    public Card getCardById(int id) {
        String select = "SELECT * FROM cards WHERE idCard=?";

        Connection databaseConnection = DbConfig.getDb();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(select);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCard(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Card mapToCard(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Card(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

    //UPDATE card_number
    public void updateCardNumber(String obj, int id) {
        String update = "UPDATE cards SET card_number=? WHERE idcard=?";

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

    //UPDATE card_expire_date
    public void updateExpireDate(String obj, int id) {
        String update = "UPDATE cards SET expire_date=? WHERE idcard=?";

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
    //UPDATE card_security_code
    public void updateCardSecurityCode(int obj, int id) {
        String update = "UPDATE cards SET security_code=? WHERE idcard=?";

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
