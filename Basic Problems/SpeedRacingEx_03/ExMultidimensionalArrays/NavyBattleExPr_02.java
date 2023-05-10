package ExMultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NavyBattleExPr_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] battlefieldMatrix = new char[n][n];

        fillMatrix(battlefieldMatrix, scanner);

        String command = scanner.nextLine();
        boolean end = false;
        List<Integer> startingCoordinates = findStartingCoordinates(battlefieldMatrix);
        int currentRow = startingCoordinates.get(0);
        int currentCol = startingCoordinates.get(1);
        battlefieldMatrix[currentRow][currentCol] = '-';

        int damage = 0;
        int destroyedCruisers = 0;

        while (!end) {
            List<Integer> coordinatesList = findNextPosition(command, currentRow, currentCol);
            currentRow = coordinatesList.get(0);
            currentCol = coordinatesList.get(1);
            char currentSymbol = battlefieldMatrix[currentRow][currentCol];

            switch (currentSymbol) {
                case '-':
                    break;
                case '*':
                    damage++;
                    battlefieldMatrix[currentRow][currentCol] = '-';
                    ;
                    if (damage == 3) {
                        battlefieldMatrix[currentRow][currentCol] = 'S';
                        System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);
                        end = true;
                        continue;
                    }
                    break;
                case 'C':
                    destroyedCruisers++;
                    battlefieldMatrix[currentRow][currentCol] = '-';
                    if (destroyedCruisers == 3) {
                        battlefieldMatrix[currentRow][currentCol] = 'S';
                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        end = true;
                        continue;
                    }
                    break;
            }
            command = scanner.nextLine();
        }


        for (int i = 0; i < battlefieldMatrix.length; i++) {

            for (int j = 0; j < battlefieldMatrix.length; j++) {
                char currentSymbol = battlefieldMatrix[i][j];
                System.out.printf("%c", currentSymbol);
            }
            System.out.println();
        }


    }

    private static List<Integer> findNextPosition(String command, int row, int col) {
        List<Integer> position = new ArrayList<>();
        if (command.equals("up")) {
            position.add(0, row - 1);
            position.add(1, col);

            return position;
        } else if (command.equals("down")) {
            position.add(0, row + 1);
            position.add(1, col);

            return position;
        } else if (command.equals("left")) {
            position.add(0, row);
            position.add(1, col - 1);

            return position;
        } else if (command.equals("right")) {
            position.add(0, row);
            position.add(1, col + 1);

            return position;
        }
        return position;
    }

    private static List<Integer> findStartingCoordinates(char[][] battlefieldMatrix) {
        List<Integer> coordinates = new ArrayList<>();

        for (int rows = 0; rows < battlefieldMatrix.length; rows++) {
            for (int cols = 0; cols < battlefieldMatrix[0].length; cols++) {
                char currentSymbol = battlefieldMatrix[rows][cols];

                if (currentSymbol == ('S')) {
                    coordinates.add(0, rows);
                    coordinates.add(1, cols);
                }
            }
        }
        return coordinates;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String currentText = scanner.nextLine();
            for (int col = 0; col < matrix.length; col++) {
                char currentSymbol = currentText.charAt(col);
                matrix[row][col] = currentSymbol;
            }
        }
    }
}
