package GoogleEx_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personsMap = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String inputData[] = input.split("\\s+");
            String name = inputData[0];
            if (!personsMap.containsKey(name)) {
               personsMap.put(name, new Person());
            }

            String command = inputData[1];
            switch (command){
                case "company":
                    String companyName = inputData[2];
                    String department = inputData[3];
                    double salary = Double.parseDouble( inputData[4]);
                    Company company = new Company(companyName, department, salary);
                    personsMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = inputData[2];
                    String pokemonType = inputData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personsMap.get(name).getPokemonCollection().add(pokemon);
                    break;
                case "parents":
                    String parentName = inputData[2];
                    String birthday = inputData[3];
                    Parent parent = new Parent(parentName, birthday);
                    personsMap.get(name).getParents().add(parent);

                    break;
                case "children":
                    String childName = inputData[2];
                    String childBirthday = inputData[3];
                    Child child = new Child(childName, childBirthday);
                    personsMap.get(name).getChildren().add(child);

                    break;
                case "car":
                    String carModel = inputData[2];
                    int carSpeed = Integer.parseInt(inputData[3]);
                    Car car = new Car(carModel, carSpeed);
                    personsMap.get(name).setCar(car);

                    break;
            }

            input = scanner.nextLine();
        }

        String personToPrint = scanner.nextLine();
        System.out.println(personToPrint);
        System.out.println(personsMap.get(personToPrint).toString());
    }
}
