import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/LibraryDB";
        String user = "root"; // use your MySQL username
        String password = "#25072006Harshit"; // your MySQL password
        return DriverManager.getConnection(url, user, password);
    }
}
