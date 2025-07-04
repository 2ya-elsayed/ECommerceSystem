package model;

import base.Product;

public class ScratchCard extends Product {
    public ScratchCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return super.getName() + " - " + super.getPrice() + " EGP - Qty: " + super.getQuantity();
    }
}
