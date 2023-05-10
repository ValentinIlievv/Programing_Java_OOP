package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(n -> n += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(n -> n -= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(n -> n *= 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(n -> System.out.print(n + " "));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbersList = add.apply(numbersList);
                    break;
                case "multiply":
                    numbersList = multiply.apply(numbersList);
                    break;
                case "subtract":
                    numbersList = subtract.apply(numbersList);
                    break;
                case "print":
                    print.accept(numbersList);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
