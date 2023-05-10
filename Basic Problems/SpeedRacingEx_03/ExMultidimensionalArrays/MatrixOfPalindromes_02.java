package ExMultidimensionalArrays;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix);
        printMatrix(matrix);

    }

    public static void fillMatrix(String[][] matrix) {
        int startNum = 0;
        char startSymbol = 'a';
        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                StringBuilder sb = new StringBuilder();

                char firstSymbol = (char) (startSymbol + row);
                char secondSymbol = (char) (firstSymbol + startNum);
                sb.append(firstSymbol);
                sb.append(secondSymbol);
                sb.append(firstSymbol);

                matrix[row][col] = sb.toString();
                ;
                startNum++;
            }
            startNum = 0;
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
