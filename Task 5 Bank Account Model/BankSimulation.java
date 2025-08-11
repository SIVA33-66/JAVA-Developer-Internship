import java.util.ArrayList;
import java.util.Scanner;



class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with ₹" + initialBalance);
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited ₹" + amount);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
public void showBalance() {
    System.out.println("Account Holder: " + accountHolder);
    System.out.println("Balance: ₹" + balance);
}

public void showTransactionHistory() {
    System.out.println("Transaction History for " + accountHolder + ":");
    for (String t : transactionHistory) {
        System.out.println(t);
    }
}
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit: ₹");
        double initialDeposit = scanner.nextDouble();

        Account account = new Account(name, initialDeposit);

        int choice;
        do {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Show Balance\n4. Transaction History\n5. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    account.deposit(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 3:
                    account.showBalance();
                    break;
                case 4:
                    account.showTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}