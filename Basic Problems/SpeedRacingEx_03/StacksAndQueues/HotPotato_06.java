package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split(" ");
        int counter = Integer.parseInt(scanner.nextLine());

        Deque<String> namesQueue = new ArrayDeque<>();
        Collections.addAll(namesQueue, namesArr);

        while (namesQueue.size() > 1) {

            for (int i = 1; i < counter; i++) {
                String kidName = namesQueue.poll();
                namesQueue.offer(kidName);
            }
            System.out.println("Removed " + namesQueue.poll());
        }

        System.out.println("Last is " + namesQueue.poll());
    }
}
