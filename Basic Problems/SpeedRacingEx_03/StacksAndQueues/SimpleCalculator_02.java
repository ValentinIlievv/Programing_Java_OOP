package StacksAndQueues;

import java.util.*;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String expresions = scanner.nextLine();
        String[] expresionParts = expresions.split(" ");
        List<String> partsList = Arrays.asList(expresionParts);
        Collections.reverse(partsList);

        for (String part : partsList) {
            stack.push(part);
        }
        while (stack.size() > 1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            int result;

            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;

                case "-":
                    result = firstNum - secondNum;
                    break;

                default:
                    System.out.println("Unknown operation" + operator);
                    return;
            }
            stack.push("" + result);
        }
        System.out.println(stack.peek());
    }
}
