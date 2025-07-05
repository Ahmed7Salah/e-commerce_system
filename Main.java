import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // create products
        TV tv = new TV(0, "LG", 2400, 3, 9);
        Cheese cheese = new Cheese(1, "Domty", 10, 12, LocalDate.of(2025, 7, 8), 0.2);
        ScratchCard scratchCard = new ScratchCard(2, "5$ Gift Card", 5, 2);


        // create customer
        Customer customer = new Customer("John", 9000);
        Cart cart = customer.getCart();

        // add items to cart
        cart.addToCart(scratchCard, 3);
        cart.addToCart(cheese, 5);
        cart.addToCart(tv, 1);
        cart.addToCart(scratchCard, 1);

        // print cart items
        for (Map.Entry<Product, Integer> p : cart.showCart().entrySet()) {
            System.out.printf("product: %s, Quantity: %d%n", p.getKey().getName(), p.getValue());
        }

        // checkout
        try {
            CheckoutService.checkout(customer);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());

        }

    }
}
