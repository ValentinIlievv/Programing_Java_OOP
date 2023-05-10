package PokemonTrainerEx_06;

import java.util.List;
import java.util.Map;

public class Trainer {

    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public List<Pokemon> getCollectionOfPokemon() {
        return collectionOfPokemon;
    }

    public boolean pokemonCheck(String command) {

        if (command.equals("Fire")) {
            for (Pokemon pokemon : collectionOfPokemon) {
                if (pokemon.getElement().equals(command)) {
                    return true;
                }
            }
        } else if (command.equals("Electricity")) {

            for (Pokemon pokemon : collectionOfPokemon) {
                if (pokemon.getElement().equals(command)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }
    public void decreasePokemonHealth(List<Pokemon> pokemonList){
        for (Pokemon pokemon : pokemonList){
            int health = pokemon.getHealth();
            if (health - 10 <= 0){
                pokemonList.remove(pokemon);
                if (pokemonList.size() == 0){
                    break;
                }
            }
            else {
                pokemon.setHealth(health - 10);
            }
        }
    }

    @Override
    public String toString(){
        return String.format(name + " " + numberOfBadges +" " + getCollectionOfPokemon().size());
    }
}
