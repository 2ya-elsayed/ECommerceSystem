package service;

import model.Cart;
import model.Customer;

public interface CheckoutService {
    void checkout(Customer customer, Cart cart);
}
