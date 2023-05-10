package ExSetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] inputArr = input.split("-");
            String name = inputArr[0];
            String phoneNumber = inputArr[1];

            phonebook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }


    }
}
