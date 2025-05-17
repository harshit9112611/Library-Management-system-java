import java.sql.*;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Connected to LibraryDB.");

            System.out.println("Enter 1 to Add Book, 2 to Show Books:");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt(); sc.nextLine();

                System.out.print("Enter Book Title: ");
                String title = sc.nextLine();

                System.out.print("Enter Book Author: ");
                String author = sc.nextLine();

                String sql = "INSERT INTO books (id, title, author) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setString(2, title);
                stmt.setString(3, author);
                stmt.executeUpdate();

                System.out.println("Book added successfully!");
            } else if (choice == 2) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM books");

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " +
                            rs.getString("title") + " by " +
                            rs.getString("author") +
                            " (Issued: " + rs.getBoolean("isIssued") + ")");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
