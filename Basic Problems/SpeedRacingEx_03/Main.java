package SpeedRacingEx_03;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            double fuelAmount = Double.parseDouble(input.split("\\s+")[1]);
            double fuelCostPerKm = Double.parseDouble(input.split("\\s+")[2]);
             Car car = new Car(model, fuelAmount, fuelCostPerKm);
             cars.put(model, car);
        }

        String command = scanner.nextLine();

        while (!command.equals("End")){
            String model = command.split("\\s+")[1];
            int kmToDrive = Integer.parseInt(command.split("\\s+")[2]);

            Car carToDrive = cars.get(model);

            if (!carToDrive.drive(kmToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }

        for (Car car : cars.values()){
            System.out.println(car.toString());
        }

    }

}
