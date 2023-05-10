package ExMultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int size = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else if (pattern.equals("B")) {
            fillMatrixPatternB(matrix);
        }
        printMatrix(matrix);

        System.out.println();
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void fillMatrixPatternA(int[][] matrix) {
        int startNum = 1;
        for (int col = 0; col < matrix.length; col++) {

            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = startNum;
                startNum++;
            }
        }
    }

    public static void fillMatrixPatternB(int[][] matrix) {
        int startNum = 1;
        for (int col = 0; col < matrix.length; col++) {
            if ((col + 1) % 2 == 0) {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = startNum;
                    startNum++;
                }
            } else {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = startNum;
                    startNum++;
                }
            }
        }
    }
}
