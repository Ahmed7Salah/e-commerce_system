import java.util.Map;


public class ShippingService {
    public static void send(Map<Shippable, Integer> items) {
        double totalWeight = 0;
        System.out.printf("** Shipment notice **%n");
        for (Map.Entry<Shippable, Integer> s : items.entrySet()) {
            double weight = s.getKey().getWeight();
            int quantity = s.getValue();
            // add weight * quantity to get total weight 
            totalWeight += weight * quantity;

            System.out.printf("%dx %s %.2fKG%n", quantity, s.getKey().getName(), weight * quantity);
        }
        System.out.printf("Total package weight: %.2fKG%n", totalWeight);
    }
}
