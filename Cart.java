import java.util.HashMap;
import java.util.Map;


/* Cart
 * fields: list 
 * methods:
 * addToCart(): adds a quantity of a product to cart if availabe else returns false
 * isEmpty(): return true if cart is empty
 * clearCart(): clear cart (after checkout)
 * getSubtotal(): return subtotal of items in cart
 * getShippableProducts(): return a list of shippable items
 */

public class Cart {
    private Map<Product, Integer> list;

    public Cart() {
        this.list = new HashMap<>();
    };

    // getter

    public Map<Product, Integer> showCart() {
        return this.list;
    }


    // helper methods

    public boolean addToCart(Product p, int quantity) {
        // check if availabe stock
        if (p.getQuantity() < quantity) return false;
        
        // check if product expired
        if (p.isExpired()) return false;

        // if product already in cart
        if (this.list.containsKey(p)) {
            this.list.put(p, this.list.get(p) + quantity);
        } else
        {
            this.list.put(p, quantity);
        }
        return true;
    }

    public double getSubtotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> p : this.list.entrySet()) {
            // price * quantity for each product in cart
            total += p.getKey().getPrice() * p.getValue();
        }

        return total;
    }


    public Map<Shippable, Integer> getShippableProducts() {
        Map<Shippable, Integer> shippableItems = new HashMap<>();

        for (Map.Entry<Product, Integer> p : this.list.entrySet()) {
            Product product = p.getKey();
            if (product instanceof Shippable) shippableItems.put((Shippable) product, p.getValue());
        }

        return shippableItems;
    }



    public boolean isEmpty() {
        return this.list.isEmpty();
    }


    public void clearCart() {
        this.list.clear();
    }

}
