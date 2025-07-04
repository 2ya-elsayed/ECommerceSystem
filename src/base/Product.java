package base;

import exception.ProductException;

import static exception.ProductException.invalidPriceOrQuantity;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw ProductException.invalidPriceOrQuantity(price, quantity);
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reduceQuantity(int amount) {
        if (amount > quantity) {
            throw ProductException.outOfStock(name);
        }
        this.quantity -= amount;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }
}
