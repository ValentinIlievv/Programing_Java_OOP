package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            String[] numsArr = scanner.nextLine().split(", ");

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(numsArr[j]);
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < rows - 1; i++) {

            for (int j = 0; j < columns - 1; j++) {
                int firstNum = matrix[i][j];
                int secondNum = matrix[i][j + 1];
                int thirdNum = matrix[i + 1][j];
                int fourthNum = matrix[i + 1][j + 1];

                int sum = firstNum + secondNum + thirdNum + fourthNum;

                if (sum > result) {
                    result = sum;
                    queue.clear();
                    queue.offer(firstNum);
                    queue.offer(secondNum);
                    queue.offer(thirdNum);
                    queue.offer(fourthNum);
                }
            }
        }
        System.out.println(queue.poll() + " " + queue.poll());
        System.out.println(queue.poll() + " " + queue.poll());
        System.out.println(result);
    }
}
