package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numList = Arrays.stream(scanner.nextLine().split(", ")).map(elem -> Integer.parseInt(elem)).collect(Collectors.toList());

        numList.removeIf(n -> n % 2 != 0);

        print(numList);
        System.out.println();

        numList.sort(Integer::compareTo);

        print(numList);


    }

    private static void print(List<Integer> numList) {
        for (int i = 0; i < numList.size(); i++) {

            if (i == numList.size() - 1) {
                System.out.print(numList.get(i));
            } else {
                System.out.print(numList.get(i) + ", ");
            }
        }
    }
}
