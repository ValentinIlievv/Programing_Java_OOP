package MultidimensionalArrays;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        fillMatrix(matrix, scanner);


        for (int row = 0; row < 8; row++) {

            for (int col = 0; col < 8; col++) {
                String currentSymbol = matrix[row][col];

                if (currentSymbol.equals("q")) {
                    if (isRealQueen(row, col, matrix)) {
                        if (diagonalsCheck(row, col, matrix)) {

                            System.out.println(row + " " + col);
                        }
                    }
                }
            }
        }


    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean isRealQueen(int row, int col, String[][] matrix) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String currentSymbol = matrix[i][j];
                if (currentSymbol.equals("q")) {
                    if (i != row && j != col) {

                        if (i == row) {
                            return false;
                        }
                        if (j == col) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    private static boolean diagonalsCheck(int row, int col, String[][] matrix) {
        if (!firstDown(row, col, matrix)) {
            return false;
        }
        if (!firstUp(row, col, matrix)) {
            return false;
        }
        if (!secondDown(row, col, matrix)) {
            return false;
        }
        if (!secondUp(row, col, matrix)) {
            return false;
        }
        return true;
    }

    private static boolean secondUp(int row, int col, String[][] matrix) {
        for (int i = 0; i < 8; i++) {

            int r = 0;
            int c = 0;

            int k = 1;
            int j = 1;
            boolean stop = false;
            if (row == 0) {
                return true;
            } else if (col == 7) {
                return true;
            }
            while (!stop) {
                String currentSymbol = matrix[row - k][col + j];
                if (currentSymbol.equals("q")) {
                    return false;
                }
                r = row - k;
                c = col + j;
                k++;
                j++;

                if (r == 0 || r == 7) {
                    stop = true;
                } else if (c == 0 || c == 7) {
                    stop = true;
                }

            }
        }
        return true;
    }

    private static boolean secondDown(int row, int col, String[][] matrix) {
        for (int i = 0; i < 8; i++) {

            int r = 0;
            int c = 0;

            int k = 1;
            int j = 1;
            boolean stop = false;
            if (row == 7) {
                return true;
            } else if (col == 0) {
                return true;
            }
            while (!stop) {
                String currentSymbol = matrix[row + k][col - j];
                if (currentSymbol.equals("q")) {
                    return false;
                }
                r = row + k;
                c = col - j;
                k++;
                j++;

                if (r == 0 || r == 7) {
                    stop = true;
                } else if (c == 0 || c == 7) {
                    stop = true;
                }

            }
        }
        return true;
    }

    private static boolean firstUp(int row, int col, String[][] matrix) {
        for (int i = 0; i < 8; i++) {

            int r = 0;
            int c = 0;

            int k = 1;
            int j = 1;
            boolean stop = false;
            if (row == 0) {
                return true;
            } else if (col == 0) {
                return true;
            }
            while (!stop) {
                String currentSymbol = matrix[row - k][col - j];
                if (currentSymbol.equals("q")) {
                    return false;
                }
                r = row - k;
                c = col - j;
                k++;
                j++;

                if (r == 0 || r == 7) {
                    stop = true;
                } else if (c == 0 || c == 7) {
                    stop = true;
                }

            }
        }
        return true;
    }

    private static boolean firstDown(int row, int col, String[][] matrix) {
        for (int i = 0; i < 8; i++) {

            int r = 0;
            int c = 0;

            int k = 1;
            int j = 1;
            boolean stop = false;
            if (row == 7) {
                return true;
            } else if (col == 7) {
                return true;
            }
            while (!stop) {
                String currentSymbol = matrix[row + k][col + j];
                if (currentSymbol.equals("q")) {
                    return false;
                }
                r = row + k;
                c = col + j;
                k++;
                j++;

                if (r == 0 || r == 7) {
                    stop = true;
                } else if (c == 0 || c == 7) {
                    stop = true;
                }

            }
        }
        return true;
    }


}

