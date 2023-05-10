package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Voina_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();

        for (int card : firstInput) {
            firstPlayerDeck.add(card);
        }

        for (int card : secondInput) {
            secondPlayerDeck.add(card);
        }

        for (int i = 0; i < 50; i++) {


            if (firstPlayerDeck.isEmpty()) {
                System.out.println("Second player win!");
                return;
            } else if (secondPlayerDeck.isEmpty()) {
                System.out.println("First player win!");
                return;
            }
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            int secondPlayerCard = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if (firstPlayerDeck.size() > secondPlayerDeck.size()) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck.size() > firstPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
