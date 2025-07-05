import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // create products
        TV tv = new TV(0, "LG", 2400, 6, 9);
        Cheese cheese = new Cheese(1, "Domty", 10, 12, LocalDate.of(2025, 7, 8), 0.2);
        ScratchCard scratchCard = new ScratchCard(2, "5$ Gift Card", 5, 2);


        // create customer
        Customer customer = new Customer("John", 9000);
        Cart cart = customer.getCart();

        // test checking out when cart is empty
        try {
            CheckoutService.checkout(customer);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());

        }

        System.out.printf("%n%n_______________%n%n");
        
        // add items to cart
        cart.addToCart(scratchCard, 3); // fails since not enough stock
        cart.addToCart(cheese, 5);
        cart.addToCart(tv, 1);
        cart.addToCart(scratchCard, 1);

        // new customer
        Customer customer2 = new Customer("Ashley", 10000);
        Cart cart2 = customer2.getCart();
        cart2.addToCart(scratchCard, 2);
        
        // print cart items to verify
        for (Map.Entry<Product, Integer> p : cart.showCart().entrySet()) {
            System.out.printf("product: %s, Quantity: %d%n", p.getKey().getName(), p.getValue());
        }
        System.out.printf("%n%n_______________%n%n");
        
        // checkout
        try {
            CheckoutService.checkout(customer);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
            
        }
        
        System.out.printf("%n%n_______________%n%n");

        
        // add many items to cart
        cart.addToCart(tv, 5);
        
        // checkout with insufficient funds
        try {
            CheckoutService.checkout(customer);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
            
        }
        
        System.out.printf("%n%n_______________%n%n");
        
        // checkout when out of stock
        try {
            CheckoutService.checkout(customer2);
        } catch (Exception e) {
            System.out.println("Checkout failed: " + e.getMessage());
            
        }
        
        System.out.printf("%n%n_______________%n%n");

    }
}
