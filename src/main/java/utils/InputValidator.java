package utils;

import java.util.Scanner;

public class InputValidator {
    // Validate number input
    public static boolean isValidNumber(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate operation input
    public static boolean isValidOperation(String input) {
        return input.matches("[+\\-*/]");
    }

    // Validate yes/no response
    public static boolean isValidYesNo(String input) {
        String lowercaseInput = input.toLowerCase();
        return lowercaseInput.equals("yes") ||
               lowercaseInput.equals("no") ||
               lowercaseInput.equals("y") ||
               lowercaseInput.equals("n");
    }

    // Helper method to get clean number input
    public static double getValidNumberInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.next();
            if (!isValidNumber(input)) {
                System.out.println("Invalid number. Please try again.");
            }
        } while (!isValidNumber(input));

        return Double.parseDouble(input);
    }

    // Helper method to get clean operation input
    public static String getValidOperationInput(Scanner scanner) {
        String input;
        do {
            System.out.print("Enter operation (+, -, *, /): ");
            input = scanner.next();
            if (!isValidOperation(input)) {
                System.out.println("Invalid operation. Please enter +, -, *, or /");
            }
        } while (!isValidOperation(input));

        return input;
    }
}
