package model;

import base.ShippableExpirableProduct;

import java.time.LocalDate;

public class Biscuits extends ShippableExpirableProduct {

    public Biscuits(String name, double price, int quantity, double weight, LocalDate expiryDate) {
        super(name, price, quantity, weight, expiryDate);
    }

    @Override
    public String toString() {
        return super.getName() + " - " + super.getPrice() + " EGP - Qty: " + super.getQuantity() +
                " - Exp: " + super.getExpiryDate() + " - Weight: " + super.getWeight() + "kg";
    }
}
