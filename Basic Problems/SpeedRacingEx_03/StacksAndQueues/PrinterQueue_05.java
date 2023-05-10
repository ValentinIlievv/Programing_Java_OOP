package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Deque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                String firstTask = printerQueue.poll();

                if (firstTask == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + firstTask);
                }

            } else {
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.pollFirst());
        }

    }
}
