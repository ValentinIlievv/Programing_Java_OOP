package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");

        Consumer<String> printNames = n -> System.out.println(n);

        Arrays.stream(namesArr).forEach(printNames);
    }
}
