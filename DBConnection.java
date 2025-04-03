import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {

    // Method to create a database if it doesn't exist
    public static void createDatabase(String dbName) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "root";

            // Establishing connection to the MySQL server (not the specific database)
            Connection con = DriverManager.getConnection(url, username, password);

            // SQL query to create the database
            String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;

            // Using PreparedStatement to create the database
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("Database '" + dbName + "' created successfully.");

            // Close resources
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error creating database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to get a connection to the specified database
    public static Connection getConnection(String dbName) {
        Connection con = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + dbName;
            String username = "root";
            String password = "root";

            // Establishing and returning the connection
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Error establishing connection: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
