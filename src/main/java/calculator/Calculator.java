package calculator;

public class Calculator {
    private int numberOfOperations = 0;
    public double calculate(double a, double b, Operation operation) {
        this.numberOfOperations += 1;
        return switch (operation) {
            case ADD -> a + b;
            case SUBTRACT -> a - b;
            case MULTIPLY -> a * b;
            case DIVIDE -> {
                if (b == 0) yield 0;
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Unknown operation");
        };
    }

    public int getNumberOfOperations() {
        return numberOfOperations;
    }
}
