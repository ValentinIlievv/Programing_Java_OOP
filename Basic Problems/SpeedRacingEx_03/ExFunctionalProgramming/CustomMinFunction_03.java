package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printMinNumber = list -> System.out.println(Collections.min(list));

        printMinNumber.accept(numbersList);

//        Function<List<Integer>, Integer> getMinNum = list -> Collections.min(list);
//        getMinNum.apply(numbersList);

    }
}
