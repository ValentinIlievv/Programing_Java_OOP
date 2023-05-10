package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printMinNumLastIndex = list -> {
            int minNum = Collections.min(numbersList);

            System.out.println(list.lastIndexOf(minNum));
        };

        printMinNumLastIndex.accept(numbersList);
//        Function<List<Integer>, Integer> getLastIndex = list -> list.lastIndexOf(Collections.min(list));
//        int lastIndex = getLastIndex.apply(numbersList);
//        System.out.println(lastIndex);
    }
}
