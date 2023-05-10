package SetsAndMapsAdvanced;

import java.util.*;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> parkingSet = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String command = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (command.equals("IN")) {
                parkingSet.add(carNumber);
            } else if (command.equals("OUT")) {
                parkingSet.remove(carNumber);
            }

            input = scanner.nextLine();
        }
        if (parkingSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        parkingSet.forEach(elem -> System.out.println(elem));
    }
}
