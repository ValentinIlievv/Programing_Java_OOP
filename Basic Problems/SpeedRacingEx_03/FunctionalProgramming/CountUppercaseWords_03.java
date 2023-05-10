package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Predicate<String> uppercase = n -> Character.isUpperCase(n.charAt(0));

        List<String> uppercaseWords = Arrays.stream(scanner.nextLine().split(" ")).filter(w -> uppercase.test(w)).collect(Collectors.toList());

        System.out.println(uppercaseWords.size());
        uppercaseWords.forEach(System.out::println);
    }
}
