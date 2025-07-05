package service.impl;

import model.base.Shippable;
import model.Cart;
import model.CartItem;
import model.Customer;
import exception.EmptyCartException;
import exception.BalanceException;
import service.CheckoutService;
import service.ShippingService;

import java.util.ArrayList;
import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    private final ShippingService shippingService;

    public CheckoutServiceImpl(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @Override
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new EmptyCartException();

        double subtotal = cart.getSubtotal();
        List<Shippable> toShip = new ArrayList<>();
        double totalWeight = 0;

        for (CartItem item : cart.getItems()) {
            var product = item.getProduct();
            if (product instanceof Shippable) {
                Shippable s = (Shippable) product;
                totalWeight += s.getWeight();
                toShip.add(s);
            }
        }

        double shippingFee = totalWeight > 0 ? 30 : 0;
        double totalAmount = subtotal + shippingFee;

        if (customer.getBalance() < totalAmount)
            throw BalanceException.insufficient(totalAmount, customer.getBalance());

        // Ship items
        if (!toShip.isEmpty()) {
            shippingService.ship(toShip);
        }

        // Print receipt
        System.out.println("** Checkout Receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() +
                    " = " + item.getTotalPrice());
            item.getProduct().reduceQuantity(item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Total: " + totalAmount);
        customer.deductBalance(totalAmount);
    }
}
