package ExStacksAndQueues;

import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static long[]  memoryFib;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        memoryFib = new long[n + 1];

        System.out.println(fib(n));

    }
    public static long fib(int n){
        if (n <= 1){
            return  1;
        }
        if (memoryFib[n]!= 0){
            return memoryFib[n];
        }

         return memoryFib[n] = fib(n-1) + fib(n-2);
    }
}
