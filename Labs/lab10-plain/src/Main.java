import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

  /**
   * Create a class User with the following private fields:
   * - id: Long
   * - firstName: String
   * - lastName: String
   * - email: String
   * - password: String
   *
   * Don't store the password in plain text. Use a hashing algorithm.
   * Create a method to check if email & password is valid.
   * The method should have the following signature:
   * - isValid(email: String, password: String): boolean
   *
   * Create a class UserRepository with the following public methods:
   * - save(user: User): User
   * - findById(id: Long): User
   * - findByEmail(email: String): User
   * - update(user: User): User
   * - deleteById(id: Long): void
   *
   * @param args
   */
  public static void main(String[] args) {
    // JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost:3306/your_database_name";
    String user = "your_username";
    String password = "your_password";

    try {
      // Establish a connection
      Connection connection = DriverManager.getConnection(url, user, password);

      // Execute a SQL query
      String query = "SELECT * FROM your_table_name";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();

      // Process the result set
      while (resultSet.next()) {
        // Access data from the result set
        String columnName = resultSet.getString("column_name");
        // Perform operations with the data
      }

      // Close resources
      resultSet.close();
      preparedStatement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}