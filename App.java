public class App {
    public static void main(String[] args) {
        String dbName = "swastika";

        // Create database using DBConnection
        DBConnection.createDatabase(dbName);

        // Create table and insert users
        // UserOperations.createUserTable(dbName);
        UserOperations.insertUser(dbName, "Alice", 25);
        UserOperations.insertUser(dbName, "Bob", 30);

        System.out.println("Operations completed successfully.");
    }
}
