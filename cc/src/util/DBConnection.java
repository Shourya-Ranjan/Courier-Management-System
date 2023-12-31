package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private DBConnection() {
        // Private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");                
                //System.out.println("Driver Loaded");
                // Get the connection string from the property file
                String connectionString = PropertyUtil.getPropertyString();
                // Establish the connection
                connection = DriverManager.getConnection(connectionString);
                //System.out.println("Db connected Successfully!!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
        return connection;
    }
}