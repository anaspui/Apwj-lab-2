import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

    public static Person login(String email, String password) throws SQLException, ClassNotFoundException {
            Connection connection = ConnectionManager.getConnection();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("userId"));
                person.setName(resultSet.getString("name"));
                return person;
            }
        return null;
    }
    public static void register(Person person) throws SQLException, ClassNotFoundException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            connection = ConnectionManager.getConnection();
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getEmail());
            preparedStatement.setString(3, person.getPassword());
            preparedStatement.executeUpdate();
    }

}
