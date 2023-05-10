package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfElemToAdd = scanner.nextInt();
        int numOfElemToPoll = scanner.nextInt();
        int x = scanner.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numOfElemToAdd; i++) {
            queue.offer(scanner.nextInt());
            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < numOfElemToPoll; i++) {
            queue.poll();
            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }
        }

        if (queue.contains(x)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
