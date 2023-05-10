package SetsAndMapsAdvanced;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shopProductMap = new TreeMap<>();

        while (!input.equals("Revision")) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            if (!shopProductMap.containsKey(shop)) {
                shopProductMap.put(shop, new LinkedHashMap<>());
                shopProductMap.get(shop).put(product, price);
            } else {
                shopProductMap.get(shop).put(product, price);
            }

            input = scanner.nextLine();
        }

        for (String shop : shopProductMap.keySet()) {

            System.out.printf("%s->%n", shop);
            for (String product : shopProductMap.get(shop).keySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", product, shopProductMap.get(shop).get(product));
            }

        }


    }
}
