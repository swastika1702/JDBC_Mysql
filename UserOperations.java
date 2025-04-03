import java.sql.*;

public class UserOperations {

    // Method to create the users table
    public static void createUserTable(String dbName) {
        try {
            // Get the database connection
            Connection con = DBConnection.getConnection(dbName);

            // SQL query to create the table
            String createSQL = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "age INT"
                    + ")";

            // Using PreparedStatement to create the table
            PreparedStatement pstmt = con.prepareStatement(createSQL);
            pstmt.executeUpdate();
            System.out.println("Table 'users' created successfully.");

            // Close the statement and connection
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error while creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to insert data into the users table
    public static void insertUser(String dbName, String name, int age) {
        try {
            // Get the database connection
            Connection con = DBConnection.getConnection(dbName);

            // SQL query to insert data
            String insertSQL = "INSERT INTO users (name, age) VALUES (?, ?)";

            // Using PreparedStatement to insert data
            PreparedStatement pstmt = con.prepareStatement(insertSQL);
            pstmt.setString(1, name);  
            pstmt.setInt(2, age);     

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User '" + name + "' inserted successfully.");
            }

            // Close the statement and connection
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error while inserting data: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
