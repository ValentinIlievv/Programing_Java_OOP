package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumbers = scanner.nextLine();
        String[] inputArr = inputNumbers.split(" ");

        Deque<String> stack = new ArrayDeque();

        for (int i = 0; i < inputArr.length ; i++) {
            String currentSymbol = inputArr[i];
            stack.push(currentSymbol);
        }

        for (Object item : stack) {

            System.out.print(item + " ");
        }

    }
}
