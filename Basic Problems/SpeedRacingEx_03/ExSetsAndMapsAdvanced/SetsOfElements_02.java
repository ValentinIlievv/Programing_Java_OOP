package ExSetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            firstSet.add(num);
        }
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            secondSet.add(num);
        }


        firstSet.retainAll(secondSet);

        firstSet.forEach(num -> System.out.print(num + " "));


    }
}
