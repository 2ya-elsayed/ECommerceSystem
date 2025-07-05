package model;

import model.base.ShippableProduct;

public class Tv extends ShippableProduct {

    public Tv(String name, double price, int quantity, double weight) {
        super(name, price, quantity, weight);
    }

    @Override
    public String toString() {
        return super.getName() + " - " + super.getPrice() + " EGP - Qty: " +
                super.getQuantity() + " - Weight: " + super.getWeight() + "kg";
    }
}
