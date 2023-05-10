package ExPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int biscuits = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        for (int i = 0; i < liquids.size(); i++) {

            int currentLiquid = liquids.get(i);
            if (ingredients.size() == 0){
                break;
            }


            for (int j = ingredients.size() - 1; j >= 0 ; j--) {
                int currentIngredient = ingredients.get(j);
                int mix = currentLiquid + currentIngredient;
                if (mix == 25){
                    biscuits++;
                    liquids.remove(i);
                    ingredients.remove(j);
                    i--;
                    j++;
                    break;
                }
                else if (mix == 50){
                    cake++;
                    liquids.remove(i);
                    ingredients.remove(j);
                    i--;
                    j++;
                    break;
                }
                else if (mix == 75){
                    pastry++;
                    liquids.remove(i);
                    ingredients.remove(j);
                    i--;
                    j++;
                    break;
                }
                else if (mix == 100){
                    pie++;
                    liquids.remove(i);
                    ingredients.remove(j);
                    i--;
                    j++;
                    break;
                }
                else {
                    liquids.remove(i);
                    i--;
                    ingredients.remove(j);
                    ingredients.add(j, currentIngredient + 3);
                    break;
                }
            }
        }

        if (biscuits > 0 && cake > 0 && pastry > 0 && pie > 0){
             System.out.println("Great! You succeeded in cooking all the food!");
        }
        else if ( biscuits == 0 || cake == 0 || pastry == 0 || pie == 0){
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.size() == 0){
            System.out.println("Liquids left: none");
        }
        else {
            System.out.print("Liquids left: ");
            for (int i = 0; i < liquids.size(); i++) {
                int currentLiquid = liquids.get(i);
                if (i == liquids.size() - 1){
                    System.out.print(currentLiquid);
                    System.out.println();
                }
                else {
                    System.out.print(currentLiquid + ", ");
                }
            }
        }
        if (ingredients.size() == 0){
            System.out.println("Ingredients left: none");
        }
        else {
            System.out.print("Ingredients left: ");
            for (int i = ingredients.size() -1; i >= 0; i--) {
                int currentIngredient = ingredients.get(i);
                if (i == 0){
                    System.out.print(currentIngredient);
                    System.out.println();
                }
                else {
                    System.out.print(currentIngredient + ", ");
                }
            }
        }

        System.out.println("Biscuit: " + biscuits );
        System.out.println("Cake: " + cake);
        System.out.println("Pie: " + pie);
        System.out.println("Pastry: " + pastry);

    }
}
