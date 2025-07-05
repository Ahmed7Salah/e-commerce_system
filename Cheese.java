import java.time.LocalDate;

public class Cheese extends PerishableProduct implements Shippable {
    private double weight;
    
    public Cheese(int id, String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(id, name, price, quantity, expiryDate);
        this.weight = weight;
    }

    @Override
    public boolean isPhysical() {
        return true;
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
    
}
