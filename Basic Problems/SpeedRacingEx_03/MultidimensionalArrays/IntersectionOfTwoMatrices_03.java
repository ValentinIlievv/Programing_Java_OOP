package MultidimensionalArrays;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][columns];
        char[][] secondMatrix = new char[rows][columns];
        char[][] thirdMatrix = new char[rows][columns];

        for (int i = 0; i < firstMatrix.length; i++) {
            String input = scanner.nextLine().replace(" ", "");

            for (int j = 0; j < firstMatrix[i].length; j++) {
                char currentSymbol = input.charAt(j);
                if (currentSymbol == '*') {
                    return;
                }
                firstMatrix[i][j] = currentSymbol;
            }
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            String input = scanner.nextLine().replace(" ", "");

            for (int j = 0; j < firstMatrix[i].length; j++) {
                char currentSymbol = input.charAt(j);
                if (currentSymbol == '*') {
                    return;
                }
                secondMatrix[i][j] = currentSymbol;
            }
        }

        for (int i = 0; i < firstMatrix.length; i++) {

            for (int j = 0; j < firstMatrix[i].length; j++) {
                char firstSymbol = firstMatrix[i][j];
                char secondSymbol = secondMatrix[i][j];

                if (firstSymbol == secondSymbol) {
                    thirdMatrix[i][j] = firstSymbol;
                } else {
                    thirdMatrix[i][j] = '*';
                }

                System.out.print(thirdMatrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
