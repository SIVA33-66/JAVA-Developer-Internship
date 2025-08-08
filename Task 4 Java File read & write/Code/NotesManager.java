import java.io.*;
import java.util.Scanner;

public class NotesManager {

    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("📒 Welcome to Notes Manager");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a note");
            System.out.println("2. View notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNote(scanner);
                    break;
                case "2":
                    viewNotes();
                    break;
                case "3":
                    System.out.println("✅ Exiting. Take care!");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }

    private static void addNote(Scanner scanner) {
        System.out.print("Type your note: ");
        String note = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(note + System.lineSeparator());
            System.out.println("📝 Note saved successfully.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save note: " + e.getMessage());
        }
    }

    private static void viewNotes() {
        System.out.println("\n📂 Your Notes:");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            boolean hasNotes = false;

            while ((line = reader.readLine()) != null) {
                System.out.println("- " + line);
                hasNotes = true;
            }

            if (!hasNotes) {
                System.out.println("(No notes found yet)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("(No notes file found. Try adding a note first.)");
        } catch (IOException e) {
            System.out.println("❌ Error reading notes: " + e.getMessage());
        }
    }
}