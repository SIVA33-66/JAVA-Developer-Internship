import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("👤 User added: " + user);
    }

    public void showBooks() {
        System.out.println("\n📖 Library Collection:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        System.out.println("\n👥 Registered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issue();
                System.out.println("✅ Issued: " + book.getTitle());
                return;
            }
        }
        System.out.println("❌ Book not available or already issued.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isIssued()) {
                book.returnBook();
                System.out.println("🔄 Returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("❌ Book not found or not issued.");
    }
}