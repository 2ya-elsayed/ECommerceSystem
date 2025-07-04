package entity;

import base.Expirable;
import base.Product;
import exception.ProductException;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw ProductException.outOfStock(product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() { return items; }

    public void setItems(List<CartItem> items) { this.items = items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<Product> getExpirableOutOfStockItems() {
        List<Product> invalids = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof Expirable && ((Expirable) p).isExpired()) {
                invalids.add(p);
            }
            if (item.getQuantity() > p.getQuantity()) {
                invalids.add(p);
            }
        }
        return invalids;
    }
}
