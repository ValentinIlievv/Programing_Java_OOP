package PokemonTrainerEx_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Trainer> trainerMap= new LinkedHashMap<>();

        while (!input.equals("Tournament")){
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String pokemonElement = input.split("\\s+")[2];
            int pokemonHealth = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (trainerMap.containsKey(trainerName)){
                trainerMap.get(trainerName).getCollectionOfPokemon().add(pokemon);

            }else {
                Trainer trainer = new Trainer(trainerName, new ArrayList<>());
                trainer.getCollectionOfPokemon().add(pokemon);
                trainerMap.put(trainerName, trainer);
            }

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();



        while (!command.equals("End")){
            if (command.equals("Fire")){

                for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {
                   if (trainer.getValue().pokemonCheck(command)){
                       int currentBadgeNumbers = trainer.getValue().getNumberOfBadges();
                       trainer.getValue().setNumberOfBadges(currentBadgeNumbers + 1);
                   }
                   else {
                       trainer.getValue().decreasePokemonHealth(trainer.getValue().getCollectionOfPokemon());
                   }
                }

            }
            else if (command.equals("Electricity")){
                for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {

                    if (trainer.getValue().pokemonCheck(command)){
                        int currentBadgeNumbers = trainer.getValue().getNumberOfBadges();
                        trainer.getValue().setNumberOfBadges(currentBadgeNumbers + 1);
                    }
                    else {
                        trainer.getValue().decreasePokemonHealth(trainer.getValue().getCollectionOfPokemon());
                    }
                }


            }


            command = scanner.nextLine();
        }


        List<Trainer> trainerList = new ArrayList<>();

        for (Map.Entry<String, Trainer> trainer : trainerMap.entrySet()) {

          trainerList.add(trainer.getValue());
        }

        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed()).forEach(System.out::println);


    }
}
