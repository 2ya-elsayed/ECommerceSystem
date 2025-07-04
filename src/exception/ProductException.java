package exception;

public class ProductException extends RuntimeException {
    public ProductException(String message) {
        super(message);
    }

    public static ProductException invalidQuantity(int quantity) {
        return new ProductException("Invalid product quantity: " + quantity + ". Quantity must be >= 0.");
    }

    public static ProductException expired(String productName) {
        return new ProductException("Product \"" + productName + "\" is expired.");
    }

    public static ProductException outOfStock(String productName) {
        return new ProductException("Product \"" + productName + "\" is out of stock or insufficient quantity.");
    }

    public static ProductException invalidPriceOrQuantity(double price, int quantity) {
        return new ProductException("Invalid product values. Price: " + price + ", Quantity: " + quantity + ". Both must be non-negative.");
    }

    public static ProductException invalidWeight(double weight) {
        return new ProductException("Invalid weight: " + weight + ". Weight must be > 0.");
    }
}
