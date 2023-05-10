package ExSetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> wordsSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            if (!wordsSet.contains(word)) {
                wordsSet.add(word);
            }
        }
        for (String word : wordsSet) {

            System.out.println(word);
        }
    }
}
