package MultidimensionalArrays;

import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                String[] input = scanner.nextLine().split(", ");
                int rows = Integer.parseInt(input[0]);
                int columns = Integer.parseInt(input[1]);

                int[][] matrix = new int[rows][columns];

                int sum = 0;

                for (int i = 0; i < rows; i++) {
                    String[] numsArr = scanner.nextLine().split(", ");

                    for (int j = 0; j < columns; j++) {
                        int currentNum = Integer.parseInt(numsArr[j]);
                        matrix[i][j] = currentNum;
                        sum += currentNum;
                    }
                }

                System.out.println(rows);
                System.out.println(columns);
                System.out.println(sum);

            }
        }


