// Physical Product subclass of Product
/* Physical products which doesn't expire
 * fields: null
 * methods:
 * isPhysical: return false since product is digital thus requires no shipping
 * isExpired: return false
 */

public class DigitalProduct extends Product {
    
    public DigitalProduct(int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    // helper methods

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isPhysical() {
        return false;
    }
    
}
