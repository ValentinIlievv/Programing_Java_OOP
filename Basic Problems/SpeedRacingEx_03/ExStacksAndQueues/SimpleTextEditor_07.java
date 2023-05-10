package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder textBuilder = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")) {
                stack.push(textBuilder.toString());
                String currentText = command.split("\\s+")[1];
                textBuilder.append(currentText);
            } else if (command.startsWith("2")) {
                stack.push(textBuilder.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                textBuilder.delete(textBuilder.length() - count, textBuilder.length());
            } else if (command.startsWith("3")) {
                int letterPosition = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(textBuilder.charAt(letterPosition - 1));
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    String undo = stack.pop();
                    textBuilder = new StringBuilder(undo);

                }
            }
        }
    }
}
