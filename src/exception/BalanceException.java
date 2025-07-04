package exception;

public class BalanceException extends RuntimeException{
    public BalanceException(String message) {
        super(message);
    }

    public static BalanceException insufficient(double required, double available) {
        return new BalanceException("Insufficient balance. Required: " + required + ", Available: " + available);
    }

    public static BalanceException invalid(double value) {
        return new BalanceException("Invalid balance: " + value + ". Balance must be >= 0.");
    }
}
