import java.util.Map;



public class CheckoutService {

    private static final double SHIPPING_RATE_PER_KG = 10.0;

    public static boolean checkout(Customer customer) {
        Cart cart = customer.getCart();
        // return false if cart is empty
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");
        
        // check for expired or out of stock items
        for (Map.Entry<Product, Integer> p : cart.showCart().entrySet()) {
            Product product = p.getKey();
    
            if (product.getQuantity() < p.getValue()) throw new RuntimeException("Product is out of stock");
            if (product.isExpired()) throw new RuntimeException("Product Expired!");
        }

        // calculate subtotal
        double subtotal = cart.getSubtotal();
        
        // calculate shipping
        double totalWeight = 0;
        for (Map.Entry<Shippable, Integer> s : cart.getShippableProducts().entrySet()) {
            // add weight * quantity to get total weight 
            totalWeight += s.getKey().getWeight() * s.getValue();
        }

        double shipping = totalWeight * SHIPPING_RATE_PER_KG;

        // calculate total
        double total = subtotal + shipping;

        // check if customer has enough balance 
        if (customer.getBalance() < total) throw new RuntimeException("Not Enough Balance!"); 

        // calculate new balance
        customer.decreaseBalance(total);

        // send shippable items 
        ShippingService.send(cart.getShippableProducts());

        System.out.println("----------------------");
        // print receipt
        System.out.printf("Subtotal: %.2f%nShipping fees: %.2f%nTotal: %.2f%nNew Balance: %.2f%n",
            subtotal,
            shipping,
            total,
            customer.getBalance()
            );


        return true;
    }
    
}
