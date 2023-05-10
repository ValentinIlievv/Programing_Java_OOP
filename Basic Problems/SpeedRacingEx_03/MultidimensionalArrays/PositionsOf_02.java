package MultidimensionalArrays;

import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] inputNums = scanner.nextLine().split("\\s+");

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(inputNums[j]);
            }
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {
                int currentNum = matrix[i][j];

                if (currentNum == numberToFind) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
