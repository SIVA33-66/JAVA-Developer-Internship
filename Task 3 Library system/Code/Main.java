import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("📚 Welcome to the Library System");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Show Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();
                    myLibrary.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter user name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter user ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    myLibrary.addUser(new User(name, id));
                    break;

                case 3:
                    myLibrary.showBooks();
                    break;

                case 4:
                    myLibrary.showUsers();
                    break;

                case 5:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    myLibrary.issueBook(issueTitle);
                    break;

                case 6:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    myLibrary.returnBook(returnTitle);
                    break;

                case 7:
                    running = false;
                    System.out.println("👋 Exiting Library System. Goodbye!");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}