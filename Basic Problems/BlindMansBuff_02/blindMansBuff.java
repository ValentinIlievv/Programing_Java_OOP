package BlindMansBuff_02;

import java.util.Scanner;

public class blindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rowsAndCols = scanner.nextLine();
        int n = Integer.parseInt(rowsAndCols.split("\\s+")[0]);
        int m = Integer.parseInt(rowsAndCols.split("\\s+")[1]);


        String[][] matrix = new String[n][m];

        int positionRow = -1;
        int positionCol = -1;

        String input = scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] inputArr = input.split("\\s+");
            for (int j = 0; j < m; j++) {
                String currentSymbol = inputArr[j];
                matrix[i][j] = currentSymbol;

                if (currentSymbol.equals("B")){
                    positionRow = i;
                    positionCol = j;
                }

            }
            input = scanner.nextLine();
        }

        int movesCount = 0;
        int opponentTouch = 0;

        String command = input;
        matrix[positionRow][positionCol] = "-";


        while (!command.equals("Finish") && opponentTouch < 3){

            switch (command){
                case "up":
                    if (positionRow - 1 >= 0){
                        positionRow--;
                        String currentSymbol = matrix[positionRow][positionCol];
                        if (currentSymbol.equals("P")){
                            opponentTouch++;
                            movesCount++;
                            matrix[positionRow][positionCol] = "-";

                        }
                        else if (currentSymbol.equals("O")){
                            positionRow++;


                        }
                        else if (currentSymbol.equals("-")){
                            movesCount++;
                        }


                    }
                    break;
                case "down":
                    if (positionRow + 1 < n) {
                        positionRow++;
                        String currentSymbol = matrix[positionRow][positionCol];
                        if (currentSymbol.equals("P")){
                            opponentTouch++;
                            movesCount++;
                            matrix[positionRow][positionCol] = "-";

                        }
                        else if (currentSymbol.equals("O")){
                            positionRow--;

                        }
                        else if (currentSymbol.equals("-")){
                            movesCount++;
                        }
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0) {
                        positionCol--;
                        String currentSymbol = matrix[positionRow][positionCol];
                        if (currentSymbol.equals("P")){
                            opponentTouch++;
                            movesCount++;
                            matrix[positionRow][positionCol] = "-";

                        }
                        else if (currentSymbol.equals("O")){
                            positionCol++;

                        }
                        else if (currentSymbol.equals("-")){
                            movesCount++;
                        }
                    }
                    break;
                case "right":
                    if (positionCol + 1 < m) {
                        positionCol++;
                        String currentSymbol = matrix[positionRow][positionCol];
                        if (currentSymbol.equals("P")){
                            opponentTouch++;
                            movesCount++;
                            matrix[positionRow][positionCol] = "-";

                        }
                        else if (currentSymbol.equals("O")){
                            positionCol--;

                        }
                        else if (currentSymbol.equals("-")){
                            movesCount++;
                        }
                    }
                    break;
            }


            command = scanner.nextLine();
        }

        matrix[positionRow][positionCol] = "B";

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponentTouch, movesCount);



    }
}
