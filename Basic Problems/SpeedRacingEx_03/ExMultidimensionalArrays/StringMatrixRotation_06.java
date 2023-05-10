package ExMultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int degrees = Integer.parseInt(command.split("\\(")[1].replace(")", "")) % 360;

        List<String> list = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            list.add(input);
            input = scanner.nextLine();
        }
        int longestWord = 0;
        for (int i = 0; i < list.size(); i++) {
            int currentWord = list.get(i).length();

            if (currentWord > longestWord) {
                longestWord = currentWord;
            }
        }

        Character[][] matrix = new Character[list.size()][longestWord];

        for (int i = 0; i < list.size(); i++) {
            int currentLength = list.get(i).length();
            int diff = longestWord - currentLength;
            for (int j = 0; j < currentLength + diff; j++) {

                if (j > currentLength - 1) {
                    matrix[i][j] = ' ';
                } else {
                    char currentSymbol = list.get(i).charAt(j);
                    matrix[i][j] = currentSymbol;
                }
            }
        }

        if (degrees == 90) {

            for (int row = 0; row < matrix[0].length; row++) {
                int i = 1;
                for (int col = 0; col < matrix.length; col++) {
                    char currentSymbol = matrix[matrix.length - i][row];
                    System.out.print(currentSymbol);
                    i++;
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int row = matrix.length - 1; row >= 0; row--) {

                for (int col = matrix[0].length - 1; col >= 0; col--) {
                    char currentSymbol = matrix[row][col];
                    System.out.print(currentSymbol);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            int i = 1;
            for (int row = 0; row < matrix[0].length; row++) {
                for (int col = 0; col <= matrix.length - 1; col++) {
                    char currentSymbol = matrix[col][matrix[0].length - i];
                    System.out.print(currentSymbol);
                }
                i++;
                System.out.println();
            }
        } else {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    char currentSymbol = matrix[row][col];
                    System.out.print(currentSymbol);
                }
                System.out.println();
            }
        }


    }
}
