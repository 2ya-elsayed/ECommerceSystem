package base;

import exception.ProductException;

public abstract class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        setWeight(weight);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw ProductException.invalidWeight(weight);
        }
        this.weight = weight;
    }
}
