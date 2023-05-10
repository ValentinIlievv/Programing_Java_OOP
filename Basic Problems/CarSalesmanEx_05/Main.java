package CarSalesmanEx_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> enginesList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficiency = null;

            if (engineData.length == 4 ){
                displacement = Integer.parseInt(engineData[2]);
                 efficiency = engineData[3];
            }
            else if (engineData.length == 3){
                if (Character.isDigit(engineData[2].charAt(0))){
                    displacement = Integer.parseInt(engineData[2]);
                }
                else {
                     efficiency = engineData[2];
                }
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesList.add(engine);

        }
        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= m; i++) {

            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String engineModel = carData[1];
            int weight = 0;
            String color = null;

            if (carData.length == 4){
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
            }
            else if (carData.length == 3){
                if (Character.isDigit(carData[2].charAt(0))){
                    weight = Integer.parseInt(carData[2]);
                }
                else {
                    color = carData[2];
                }
            }
            Engine carEngine = null;
            for (Engine engine : enginesList){
                if (engineModel.equals(engine.getModel())){
                    carEngine = engine;
                    break;
                }
            }
            Car car = new Car(model, carEngine, weight, color);
            System.out.println(car.toString());
        }

    }
}
