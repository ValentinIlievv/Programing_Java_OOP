package StacksAndQueues;

import java.util.*;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArr = scanner.nextLine().split(" ");
        int steps = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> namesQueue = new PriorityQueue<>();
        Collections.addAll(namesQueue, namesArr);
        int currentStep = 1;
        while (namesQueue.size() > 1) {

            for (int i = 1; i < steps; i++) {
                String kidName = namesQueue.poll();
                namesQueue.offer(kidName);
            }
            if (isPrime(currentStep)) {
                System.out.println("Prime " + namesQueue.peek());
            } else {
                System.out.println("Removed " + namesQueue.poll());
            }

            currentStep++;
        }

        System.out.println("Last is " + namesQueue.poll());
    }

    private static boolean isPrime(int currentStep) {
        if (currentStep == 1) {
            return false;
        }
        for (int i = 2; i < currentStep; i++) {
            if (currentStep % i == 0) {
                return false;
            }
        }
        return true;
    }
}
