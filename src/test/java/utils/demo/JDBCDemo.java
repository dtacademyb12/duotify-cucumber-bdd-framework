package utils.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        // Process the result using ResultSet interface methods

        resultSet.next(); //Moves the cursor forward one row from its current position
        String name = resultSet.getString(1);
        System.out.println(name);
//        System.out.println(resultSet.getString("name"));

//        resultSet.absolute(6); //Moves the cursor to the given row number
//
//        System.out.println(resultSet.getObject("name"));
//
//        resultSet.beforeFirst(); // Moves the cursor to the front of this ResultSet object, just before the first row
//
//        while(resultSet.next()){
//            System.out.println(resultSet.getInt(1) + " " +  resultSet.getString(2));
//
//
//        }
//
//        // Find the row numbers
//        resultSet.beforeFirst();
//
//        // Navigate to the last row and get the row number
        resultSet.last(); //Moves the cursor to the last row in this ResultSet object.
        int row = resultSet.getRow();  //Retrieves the current row number, non-zero based
//
//        System.out.println("The number of rows: " + row);
//
//
//        // Get the number of columns
//
//        // Access the metadata
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
//        // get the column name
//        String columnNameFirst = metaData.getColumnName(1);
//
//        System.out.println(columnCount);
//        System.out.println(columnNameFirst);
//
//        // iterate through each cell of the ResultSet and print
//
        resultSet.beforeFirst();
//
        for (int i = 1; i <= row; i++) {
            //go to next row
            resultSet.next();
            for (int j = 1; j <= columnCount; j++) {

                System.out.print(resultSet.getObject(j) + "\t");

            }
            System.out.println();
        }
//
//        // iterate through each cell of the ResultSet and store the data in a List<List<Object>>
//
//        resultSet.beforeFirst();
//        List<List<Object>> list = new ArrayList<>();
//
//        for (int i = 1; i <= row; i++) {
//            //go to next row
//            resultSet.next();
//            List<Object > each =  new ArrayList<>();
//            for (int j = 1; j <= columnCount; j++) {
//
//                each.add(resultSet.getObject(j));
//
//            }
//            list.add(each);
//        }
//
//        System.out.println("The data: "  + list);
//
//
//        System.out.println(list.get(2).get(1));
//
//
//        // To send an update statement (Create, Update, Delete)
//        resultSet.beforeFirst();
//        statement.executeUpdate("INSERT INTO genres (name) values('two-step')");
//
//        statement.executeUpdate("INSERT INTO genres (name) values('two-step')");
//
//
//
//
//
//        // Close the connection
//        resultSet.close();
//        statement.close();
//        connection.close();

    }
}
