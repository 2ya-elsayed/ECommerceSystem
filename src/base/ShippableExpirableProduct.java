package base;

import exception.ProductException;

import java.time.LocalDate;

public abstract class ShippableExpirableProduct extends Product implements Shippable, Expirable {
    private double weight;
    private LocalDate expiryDate;

    public ShippableExpirableProduct(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity);
        if (weight <= 0) throw ProductException.invalidWeight(weight);
        this.weight = weight;
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
