package ApocalypsePreparation_01;

import java.util.*;

public class apocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        String[] inputTextiles = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputTextiles.length; i++) {
            textiles.offer(Integer.parseInt(inputTextiles[i]));
        }

        String[] inputMedicaments = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputMedicaments.length; i++) {
            medicaments.push(Integer.parseInt(inputMedicaments[i]));
        }
        int patch = 0;
        int bandage = 0;
        int medKit = 0;

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textilesNum = textiles.poll();
            int medicamentsNum = medicaments.pop();
            int sum = textilesNum + medicamentsNum;

            if (sum == 30) {
                patch++;
            } else if (sum == 40) {
                bandage++;
            } else if (sum == 100) {
                medKit++;
            } else {
                if (sum > 100) {
                    medKit++;
                    int diff = sum - 100;
                    int addResources = medicaments.pop() + diff;
                    medicaments.push(addResources);
                } else {
                    medicamentsNum += 10;
                    medicaments.push(medicamentsNum);
                }
            }
        }
        if (textiles.isEmpty() && medicaments.isEmpty()){
            System.out.println("Textiles and medicaments are both empty.");
         }
        else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }

        Map<String, Integer> items = new TreeMap<>();
        if (patch > 0) {
            items.put("Patch", patch);
        }
        if (bandage > 0) {
            items.put("Bandage", bandage);
        }
        if (medKit > 0) {
            items.put("MedKit", medKit);
        }

        for (int i = 0; i < items.size(); i++) {
            int maxValue = 0;
            String name = "";
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                int currentValue = entry.getValue();
                if (currentValue > maxValue) {
                    maxValue = currentValue;
                    name = entry.getKey();
                }
            }
            System.out.println(name + " - " + maxValue);
            items.remove(name);
        }
        if (items.size() > 0) {
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }

        }

        if (medicaments.size() > 0) {
            System.out.print("Medicaments left: ");
            for (int num : medicaments) {
                if (medicaments.size() == 1) {
                    System.out.print(medicaments.pop());
                } else {
                    System.out.print(medicaments.pop() + ", ");
                }
            }

        } else if (textiles.size() > 0) {
            System.out.print("Textiles left: ");
            for (int num : textiles) {
                if (textiles.size() == 1) {
                    System.out.print(textiles.poll());
                } else {
                    System.out.print(textiles.poll() + ", ");
                }
            }

        }




    }
}
