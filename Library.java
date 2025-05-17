import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully!");
    }
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("📂 No books in the library.");
            return;
        }
        System.out.println("📚 Books in the library:");
        for (Book b : books) {
     System.out.println(b);
    }
    }
    public Book searchBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
   }
  }
        return null;
 }
    public boolean removeBook(int id) {
     Book b = searchBook(id);
     if (b != null) {
   books.remove(b);
     return true;
     }
     return false;
    }
}
