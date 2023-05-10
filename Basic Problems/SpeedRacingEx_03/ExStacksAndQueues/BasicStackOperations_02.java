package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfElemToPush = scanner.nextInt();
        int numOfElemToPop = scanner.nextInt();
        int x = scanner.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numOfElemToPush; i++) {
            stack.push(scanner.nextInt());
            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < numOfElemToPop; i++) {
            stack.pop();
            if (stack.isEmpty()) {
                System.out.println(0);
                return;
            }
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }

    }
}
