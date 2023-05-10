package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            } else {
                if (map.get(continent).containsKey(country)) {
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                }
            }
        }

        for (String continent : map.keySet()) {
            System.out.println(continent + ":");

            for (String country : map.get(continent).keySet()) {

                System.out.printf("%s -> ", country);
                printList(map.get(continent).get(country));
                System.out.println();
            }

        }
    }

    public static void printList(List<String> list) {


        for (int i = 0; i < list.size(); i++) {
            String currentCity = list.get(i);
            if (i == list.size() - 1) {
                System.out.printf("%s", currentCity);
            } else {
                System.out.printf("%s, ", currentCity);
            }
        }
    }
}
