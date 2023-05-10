package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split("\\s+");

        Consumer<String> printWithAppendSir = n -> System.out.println("Sir " + n);

        Arrays.stream(namesArr).forEach(printWithAppendSir);
    }
}
