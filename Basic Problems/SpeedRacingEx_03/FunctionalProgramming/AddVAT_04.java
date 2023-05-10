package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> priceWithVAT = x -> x * 1.2;
        Function<String, Double> parse = x -> Double.parseDouble(x);
        Consumer<Double> print = x -> System.out.printf("%.2f%n", x);


        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", ")).map(x -> parse.apply(x))
                .map(x -> priceWithVAT.apply(x)).forEach(x -> print.accept(x));
    }
}
