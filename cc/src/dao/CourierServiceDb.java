package dao;
import java.sql.Connection;
import util.DBConnection;

public class CourierServiceDb {

    // Static variable to hold the database connection
    public static Connection connection;

    // Constructor to initialize the database connection
    public CourierServiceDb() {
        // Invoke the method in DBConnection class to get the connection
        connection = DBConnection.getConnection();
    }


    // method to close the database connection
    public  void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
//            	System.out.println("Closing db connection");
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}