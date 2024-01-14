package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    // am nevoie de o clasa separata password
    public static void main(String[] args) {
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

        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/gestiune";
        String user = "root";
        String password = "Romania2023!";

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Execute a SQL query
            String query = "SELECT * FROM gestiune.adresa";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("    Strazile sunt: ");

            // Process the result set
            while (resultSet.next()) {
                // Access data from the result set
                String columnName = resultSet.getString("strada");
                // Perform operations with the data
                System.out.println(columnName);
            }

            // Partea mea:
            // Execute a SQL query
            String query1 = "SELECT * FROM gestiune.client";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            ResultSet resultSet1 = preparedStatement1.executeQuery();

            System.out.println("\n    Denumirile sunt: ");

            while (resultSet1.next()) {
                // Access data from the result set
                String columnName1 = resultSet1.getString("denumire");
                // Perform operations with the data
                System.out.println(columnName1);
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