package OpinionPollEx_01.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Person person = new Person(name , age);
            personList.add(person);
        }

       personList = personList.stream().filter(person -> person.getAge() > 30).collect(Collectors.toList());

        personList.sort(Comparator.comparing(person -> person.getName()));


        for (Person person : personList){

            System.out.println(person.toString());
        }
    }
}
