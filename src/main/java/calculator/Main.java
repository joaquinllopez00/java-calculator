package calculator;
import utils.InputValidator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;
        Calculator calculator = new Calculator();
        while (continueCalculating) {
            // Get validated inputs
            double num1 = InputValidator.getValidNumberInput(scanner, "Enter first number: ");
            String symbol = InputValidator.getValidOperationInput(scanner);
            double num2 = InputValidator.getValidNumberInput(scanner, "Enter second number: ");

            try {
                Operation operation = Operation.fromSymbol(symbol);
                double result = calculator.calculate(num1, num2, operation);
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask about continuing
            String answer;
            do {
                System.out.print("Would you like to perform another calculation? (yes/no): ");
                answer = scanner.next().toLowerCase();
                if (!InputValidator.isValidYesNo(answer)) {
                    System.out.println("Please answer with yes/no or y/n");
                }
            } while (!InputValidator.isValidYesNo(answer));

            continueCalculating = answer.equals("yes") || answer.equals("y");
        }

        System.out.println("Thank you for using the calculator. You completed " + calculator.getNumberOfOperations() + " calculations today :)");
        scanner.close();
    }
}