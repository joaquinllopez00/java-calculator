package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    void calculate() {
        assertAll(() -> assertEquals(5, calculator.calculate(10, 2, Operation.DIVIDE)),
                () -> assertEquals(10, calculator.calculate(5 ,2, Operation.MULTIPLY)));
    }

    @Test
    void getNumberOfOperations() {
        calculator = new Calculator();
        assertEquals(0, calculator.getNumberOfOperations());
        calculator.calculate(1,1,Operation.MULTIPLY);
        calculator.calculate(1,1,Operation.MULTIPLY);
        calculator.calculate(1,1,Operation.MULTIPLY);
        assertEquals(3, calculator.getNumberOfOperations());
    }
}