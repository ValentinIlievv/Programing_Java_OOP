package MultidimensionalArrays;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 1; i++) {
            int plusRow = 0;
            for (int j = 0; j < n; j++) {
                int num = matrix[i + plusRow][j];
                System.out.print(num + " ");
                plusRow++;
            }
        }
        System.out.println();

        for (int i = 0; i < 1; i++) {
            int minusRow = 0;
            int row = n - 1;
            for (int j = 0; j < n; j++) {
                int num = matrix[row - minusRow][j];
                System.out.print(num + " ");
                minusRow++;
            }
        }


    }
}
