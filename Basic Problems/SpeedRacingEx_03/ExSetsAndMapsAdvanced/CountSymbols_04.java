package ExSetsAndMapsAdvanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> countMap = new TreeMap();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            if (!countMap.containsKey(currentSymbol)) {
                countMap.put(currentSymbol, 1);
            } else {
                int currentValue = countMap.get(currentSymbol);
                countMap.put(currentSymbol, currentValue + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {

            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
