package utils;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InputValidatorTest {

    @Test
    void testIsValidNumber() {
        assertTrue(InputValidator.isValidNumber("123"));
        assertTrue(InputValidator.isValidNumber("123.45"));
        assertFalse(InputValidator.isValidNumber("abc"));
        assertFalse(InputValidator.isValidNumber("12a3"));
    }

    @Test
    void testIsValidOperation() {
        assertTrue(InputValidator.isValidOperation("+"));
        assertTrue(InputValidator.isValidOperation("-"));
        assertTrue(InputValidator.isValidOperation("*"));
        assertTrue(InputValidator.isValidOperation("/"));
        assertFalse(InputValidator.isValidOperation("x"));
        assertFalse(InputValidator.isValidOperation("1"));
    }

    @Test
    void testIsValidYesNo() {
        assertTrue(InputValidator.isValidYesNo("yes"));
        assertTrue(InputValidator.isValidYesNo("no"));
        assertTrue(InputValidator.isValidYesNo("y"));
        assertTrue(InputValidator.isValidYesNo("n"));
        assertTrue(InputValidator.isValidYesNo("YES"));
        assertTrue(InputValidator.isValidYesNo("No"));
        assertFalse(InputValidator.isValidYesNo("maybe"));
        assertFalse(InputValidator.isValidYesNo("123"));
    }

    @Test
    void testGetValidNumberInput() {
        // Mock Scanner input
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("abc", "12.34");

        // Capture output for validation
        double result = InputValidator.getValidNumberInput(scanner, "Enter a number: ");
        assertEquals(12.34, result);

        // Verify interactions
        verify(scanner, times(2)).next();
    }

    @Test
    void testGetValidOperationInput() {
        // Mock Scanner input
        Scanner scanner = mock(Scanner.class);
        when(scanner.next()).thenReturn("x", "+");

        // Capture output for validation
        String result = InputValidator.getValidOperationInput(scanner);
        assertEquals("+", result);

        // Verify interactions
        verify(scanner, times(2)).next();
    }
}
