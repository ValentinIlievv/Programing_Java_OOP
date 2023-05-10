package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if (currentSymbol == '(') {
                stack.push(i);
            } else if (currentSymbol == ')') {
                int startIndex = stack.pop();
                String expresion = input.substring(startIndex, i + 1);
                System.out.println(expresion);
            }
        }
    }
}
