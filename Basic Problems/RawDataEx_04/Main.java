package RawDataEx_04;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> fragileCargoType = new ArrayList<>();
        List<Car> flammableCargoType = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tire1Pressure = Double.parseDouble(data[5]);
            int tire1Age = Integer.parseInt(data[6]);
            double tire2Pressure = Double.parseDouble(data[7]);
            int tire2Age = Integer.parseInt(data[8]);
            double tire3Pressure = Double.parseDouble(data[9]);
            int tire3Age = Integer.parseInt(data[10]);
            double tire4Pressure = Double.parseDouble(data[11]);
            int tire4Age = Integer.parseInt(data[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire);

            if (cargoType.equals("fragile")){
                fragileCargoType.add(car);
            }
            else if (cargoType.equals("flamable")){
                flammableCargoType.add(car);
            }

        }

        String command = scanner.nextLine();

        if (command.equals("fragile")){
            for (Car car : fragileCargoType){
                car.printFragile();
            }
        }
        else if (command.equals("flamable")){
            for (Car car : flammableCargoType){
                car.printFlammable();
            }
        }

    }
}
