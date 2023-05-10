package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();

        String currentUrl = scanner.nextLine();

        while (!currentUrl.equals("Home")) {
            if (currentUrl.equals("back")) {
                if (backHistory.isEmpty() || backHistory.size() == 1) {
                    System.out.println("no previous URLs");
                    currentUrl = scanner.nextLine();

                    continue;
                }

                forwardHistory.addFirst(backHistory.pop());
                System.out.println(backHistory.peek());

            }

            if (currentUrl.equals("forward")) {
                if (forwardHistory.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forwardHistory.peek());
                    backHistory.push(forwardHistory.poll());
                }
            }
            if (!currentUrl.equals("back") && !currentUrl.equals("forward")) {
                backHistory.push(currentUrl);
                System.out.println(backHistory.peek());
                forwardHistory.clear();
            }


            currentUrl = scanner.nextLine();
        }
    }
}
