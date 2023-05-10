package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbersList);
        int n = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = num -> num % n == 0;

        numbersList.removeIf(isDivisible);

        numbersList.forEach(num -> System.out.print(num + " "));
    }
}
