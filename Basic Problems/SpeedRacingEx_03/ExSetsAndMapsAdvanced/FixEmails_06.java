package ExSetsAndMapsAdvanced;

import java.util.Locale;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            String[] arr = email.split("\\.");
            String end = arr[arr.length - 1].toLowerCase(Locale.ROOT);

            if (!end.equals("uk") && !end.equals("us") && !end.equals("com")) {
                System.out.printf("%s -> %s%n", name, email);
            }

            name = scanner.nextLine();
        }
    }
}
