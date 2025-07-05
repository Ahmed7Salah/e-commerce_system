// Product Class
/*
 * Product fields: id, name, price, quantity
 * methods:
 * getId() - returns the Id of the product
 * getName() - returns the name of the product
 * getPrice() - returns the price of the product
 * getQuantity() - returns the quantity of the product
 * reduceQuantity(amount) - reduce the quantity of this product by this amount and return the new quantity
 * isExpired() - return true if product is expired (for perishable products only)
 * isPhysical() - return true if product is physical (thus requires shipping)
 */


public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // getters

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }


    // helper methods
    
    public int reduceQuantity(int amount) {
        this.quantity -= amount;
        return this.quantity;
    }
    
    public abstract boolean isExpired();

    public boolean isPhysical() {
        return false;
    };


    // necessary Overrided methods

    @Override
    public boolean equals(Object o) {
        // if same object return true
        if (this == o) return true;
        // return false if o is null or they are of different classes
        if (o == null || this.getClass() != o.getClass()) return false;

        // compare products by name
        Product sec = (Product) o;
        return this.name.equals(sec.getName());
    }

    @Override
    public int hashCode() {
        // hash based on product name
        return this.name.hashCode();
    }



}
