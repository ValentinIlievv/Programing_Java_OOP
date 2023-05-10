package ExStacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> openParentheses = new ArrayDeque<>();
        Deque<Character> closedParentheses = new ArrayDeque<>();

        for (char bracket : input.toCharArray()) {

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                openParentheses.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                closedParentheses.offer(bracket);
            }
        }
        boolean isBalanced = false;
        if (openParentheses.size() == closedParentheses.size()) {
            for (int i = 0; i < openParentheses.size(); i++) {
                char openBracket = openParentheses.pop();
                char closedBracket = closedParentheses.poll();

                switch (openBracket) {
                    case '(':
                        if (closedBracket == ')') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;
                        }
                        break;
                    case '[':
                        if (closedBracket == ']') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;

                        }
                        break;
                    case '{':
                        if (closedBracket == '}') {
                            isBalanced = true;
                        } else {
                            isBalanced = false;
                        }
                        break;

                }

            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
