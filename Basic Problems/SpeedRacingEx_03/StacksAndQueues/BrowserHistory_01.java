package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String currentUrl = scanner.nextLine();

        while (!currentUrl.equals("Home")) {

            if (currentUrl.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                    currentUrl = scanner.nextLine();

                    continue;
                }
                history.pop();
            } else {
                history.push(currentUrl);
            }
            System.out.println(history.peek());

            currentUrl = scanner.nextLine();
        }

    }
}
