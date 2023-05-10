package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        if (decimal < 0){
            return;
        }
        if (decimal == 0){
            System.out.println(0);
        }
        while (decimal > 0) {
            stack.push(decimal % 2 + "");
            decimal = decimal / 2;

        }
        for (String num : stack) {

            System.out.print(num);
        }
    }
}
