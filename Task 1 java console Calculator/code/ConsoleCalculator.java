import java.util.Scanner;

public class ConsoleCalculator {


	  
	    static double add(double x, double y) {
	        return x + y;
	    }

	    static double subtract(double x, double y) {
	        return x - y;
	    }

	    static double multiply(double x, double y) {
	        return x * y;
	    }

	    static double divide(double x, double y) {
	        if (y == 0) {
	            System.out.println("Oops! You can't divide by zero.");
	            return Double.NaN;
	        }
	        return x / y;
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        boolean keepGoing = true;

	        System.out.println("👋 Welcome to the Friendly Calculator!");
	        System.out.println("You can add (+), subtract (-), multiply (*), or divide (/).");

	        while (keepGoing) {
	            System.out.print("\nEnter your first number: ");
	            double num1 = input.nextDouble();

	            System.out.print("Choose an operator (+, -, *, /): ");
	            char operator = input.next().trim().charAt(0);

	            System.out.print("Enter your second number: ");
	            double num2 = input.nextDouble();

	            double result;

	            switch (operator) {
	                case '+':
	                    result = add(num1, num2);
	                    break;
	                case '-':
	                    result = subtract(num1, num2);
	                    break;
	                case '*':
	                    result = multiply(num1, num2);
	                    break;
	                case '/':
	                    result = divide(num1, num2);
	                    break;
	                default:
	                    System.out.println("Hmm... that doesn't look like a valid operator.");
	                    continue; // skip the rest and restart the loop
	            }

	            System.out.println("✅ Your result: " + result);

	            System.out.print("Would you like to calculate again? (yes/no): ");
	            String answer = input.next().trim().toLowerCase();
	            keepGoing = answer.equals("yes");
	        }

	        System.out.println("\nThanks for using the Friendly Calculator. Have a great day! 😊");
	        input.close();
	    }
	}

