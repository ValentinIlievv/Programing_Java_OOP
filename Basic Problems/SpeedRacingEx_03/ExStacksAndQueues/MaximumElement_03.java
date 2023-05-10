package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsCount = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commandsCount; i++) {
            int command = scanner.nextInt();

            if (command == 1) {
                int num = scanner.nextInt();
                stack.push(num);
            } else if (command == 2) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (command == 3) {
                System.out.println(Collections.max(stack));
            }
        }
    }
}
