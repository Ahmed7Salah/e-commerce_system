// Physical Product subclass of Product
/* Physical products which doesn't expire
 * fields: weight
 * methods:
 * isPhysical: return true since product is physical thus requires shipping
 * getWeight: return the weight of the product
 * isExpired: return false
 */

public class PhysicalProduct extends Product implements Shippable {
    private double weight;
    
    public PhysicalProduct(int id, String name, double price, int quantity, double weight) {
        super(id, name, price, quantity);
        this.weight = weight;
    }

    // getter

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getName() {
        return super.getName();
    }



    // helper methods

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isPhysical() {
        return true;
    }
    
}
