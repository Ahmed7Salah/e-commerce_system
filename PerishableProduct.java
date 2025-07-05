import java.time.LocalDate;

// Perishable Product subclass of Product
/* Products which could expire
 * fields: expiryDate
 * methods:
 * isExpired: return true if product expired
 */
public class PerishableProduct extends Product {
    private LocalDate expiryDate;

    public PerishableProduct(int id, String name, double price, int quantity, LocalDate expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expiryDate);
    }
    
}
