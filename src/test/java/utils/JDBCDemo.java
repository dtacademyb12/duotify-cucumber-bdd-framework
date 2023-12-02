package utils;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://database-1.cb72canasobc.us-east-2.rds.amazonaws.com/duotify2";
        //jdbc:{driverType}://{urlToDB/schema}

        String username = "duotech";
        String password = "duotech2024";

        //establishes a connectiona nd returns an object that represents an established connection
        Connection connection = DriverManager.getConnection(url, username, password);

        //No suitable driver found for jdbc:mysql://database-1.cb72canasobc.us-east-2.rds.amazonaws.com/duotify2

        System.out.println("Connection established");

        // Create a statement that represents a SQL query

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        // Execute the query and get the result
        ResultSet resultSet = statement.executeQuery("SELECT * FROM genres");

        // Process the result using ResultSet interface methods

        resultSet.next(); //Moves the cursor forward one row from its current position
        String name = resultSet.getString(1);
        System.out.println(name);
        System.out.println(resultSet.getString("name"));

        resultSet.absolute(6); //Moves the cursor to the given row number

        System.out.println(resultSet.getObject("name"));


        // Close the connection
        connection.close();

    }
}
