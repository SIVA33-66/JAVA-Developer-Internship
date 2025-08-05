import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting program. 👋");
                default -> System.out.println("❗ Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n===== Student Record Management =====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void addStudent() {
        int id = getIntInput("Enter ID: ");
        String name = getStringInput("Enter name: ");
        double marks = getDoubleInput("Enter marks: ");
        students.add(new Student(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠️ No student records found.");
            return;
        }
        System.out.println("\nStudent Records:");
        for (Student s : students) {
            s.display();
        }
    }

    private static void updateStudent() {
        int id = getIntInput("Enter ID to update: ");
        for (Student s : students) {
            if (s.getId() == id) {
                String name = getStringInput("Enter new name: ");
                double marks = getDoubleInput("Enter new marks: ");
                s.setName(name);
                s.setMarks(marks);
                System.out.println("✅ Record updated.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    private static void deleteStudent() {
        int id = getIntInput("Enter ID to delete: ");
        students.removeIf(s -> s.getId() == id);
        System.out.println("🗑️ Record deleted (if found).");
    }

   private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        scanner.nextLine(); 
        return scanner.nextLine();
    }
}