import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Library library = new Library();
     Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Issue Book  by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
  System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                 scanner.nextLine();
                System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    break;

                case 2:
                    library.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    Book found = library.searchBook(searchId);
                    if (found != null) {
                        System.out.println("✅ Book Found: " + found);
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    boolean removed = library.removeBook(removeId);
                    if (removed) {
                        System.out.println("✅ Book removed successfully.");
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 5:
                     System.out.print("Enter Book ID to issue: ");
                     int issueId = scanner.nextInt();
                    Book bookToIssue = library.searchBook(issueId);
                     if (bookToIssue != null) {
                     if (!bookToIssue.isIssued()) {
                     bookToIssue.setIssued(true);
                      System.out.println("✅ Book issued successfully.");
                    } else {
                        System.out.println("⚠️ Book is already issued.");
            }
                     } else {
            System.out.println("❌ Book not found.");
            }
                   break;
case 6 :
System.out.println("👋 Exiting... Thank you!");
break;
                   

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}