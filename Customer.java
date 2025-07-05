public class Customer {
    private String name;
    private double balance;
    private Cart cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    // getters

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public Cart getCart() {
        return this.cart;
    }


    // helper methods

    public double decreaseBalance(double amount) {
        this.balance -= amount;
        return this.balance;
    }
}
