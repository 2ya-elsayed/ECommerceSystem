import base.Product;
import entity.Cart;
import entity.Customer;
import exception.BalanceException;
import exception.EmptyCartException;
import exception.ProductException;
import model.Biscuits;
import model.Cheese;
import service.CheckoutService;
import service.ShippingService;
import service.impl.CheckoutServiceImpl;
import service.impl.ShippingServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Services
        ShippingService shippingService = new ShippingServiceImpl();
        CheckoutService checkoutService = new CheckoutServiceImpl(shippingService);

        // 2. Create products
        Cheese cheese = new Cheese("Cheese", 100, 10, 0.2, LocalDate.now().plusDays(5));
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, 0.7, LocalDate.now().plusDays(2));
//        Cheese expiredCheese = new Cheese("Expired Cheese", 100, 10, 0.2, LocalDate.now().minusDays(1)); // Expired

        // 3. Create customer
        Customer customer = new Customer("Aya", 1000);

        // 4. Fill cart
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);

        // Fill cart with invalid data
//        cart.add(expiredCheese, 2);

        // 5. Validate cart BEFORE checkout
        List<Product> invalids = cart.getExpirableOutOfStockItems();
        if (!invalids.isEmpty()) {
            System.out.println("Invalid products:");
            for (Product p : invalids) {
                System.out.println("- " + p.getName());
            }
            return;
        }

        // 6. Checkout
        try {
            checkoutService.checkout(customer, cart);
        } catch (BalanceException | EmptyCartException | ProductException e) {
            System.out.println("Checkout failed: " + e.getMessage());
        }
    }
}