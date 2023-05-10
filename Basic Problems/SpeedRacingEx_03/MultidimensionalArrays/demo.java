package MultidimensionalArrays;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        fillMatrix(matrix,scanner);

        firstUp(4, 3 , matrix);




    }
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length ; row++) {

            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    private static boolean firstUp(int row, int col, String[][]matrix){
        for (int i = 0; i < 8; i++) {

            int r = 0;
            int c = 0;

            int k = 1;
            int j = 1;
            while (r >= 0 && c <= 7 ){
                String currentSymbol = matrix[row - k][col - j];
                r = row - k;
                c = col - j;
                k ++;
                j++;

                if (r == 0 || r == 8){
                    c = 8;
                }else if (c == 0||c == 7){
                    r = -1;
                }

            }
        }
        return  true;
    }
}
