import java.util.Map;


public class ShippingService {
    public static void send(Map<Shippable, Integer> items) {
        double totalWeight = 0;
        for (Map.Entry<Shippable, Integer> s : items.entrySet()) {
            double weight = s.getKey().getWeight();
            int quantity = s.getValue();
            // add weight * quantity to get total weight 
            totalWeight += weight * quantity;

            System.out.printf("%d %s %.2fKG%n", quantity, s.getKey().getName(), weight * quantity);
        }
        System.out.printf("Total Weight: %.2fKG%n", totalWeight);
    }
}
