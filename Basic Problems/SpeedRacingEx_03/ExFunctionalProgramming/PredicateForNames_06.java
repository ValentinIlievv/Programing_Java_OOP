package ExFunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

//        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
//
//        Predicate<String> predicate = name -> name.length() > length;
//
//        namesList.removeIf(predicate);
//
//        namesList.forEach(name -> System.out.println(name));
        String[] namesArr = scanner.nextLine().split("\\s+");

        Predicate<String> checkValidLength = name -> name.length() <= length;

        Arrays.stream(namesArr).filter(checkValidLength).forEach(System.out::println);

    }
}
