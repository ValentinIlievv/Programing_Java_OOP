package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        Map<Double, Integer> countMap = new LinkedHashMap<>();

        System.out.println();

        for (int i = 0; i < inputArr.length; i++) {
            double currentNum = Double.parseDouble(inputArr[i]);
            if (countMap.containsKey(currentNum)) {
                int value = countMap.get(currentNum);
                countMap.put(currentNum, value + 1);
            } else {
                countMap.put(currentNum, 1);
            }
        }

        for (Double key : countMap.keySet()) {

            System.out.printf("%.1f -> %d%n", key, countMap.get(key));

        }
    }


}
