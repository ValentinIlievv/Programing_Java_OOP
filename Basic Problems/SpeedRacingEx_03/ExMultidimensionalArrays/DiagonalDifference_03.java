package ExMultidimensionalArrays;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        ;

        int[][] matrix = new int[size][size];


        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < 1; col++) {
                int currentSymbol = matrix[row][row];
                firstDiagonalSum += currentSymbol;
            }
        }

        int count = 0;
        for (int row = size - 1; row >= 0; row--) {
            for (int i = 0; i < 1; i++) {
                int currentSymbol = matrix[row][count];
                secondDiagonalSum += currentSymbol;
                count++;
            }
        }

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));


    }

}
