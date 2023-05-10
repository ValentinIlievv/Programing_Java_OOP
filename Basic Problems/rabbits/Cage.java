package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void add(Rabbit rabbit){
        if (data.size() < this.capacity){
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        Rabbit rabbit = data.stream().filter(r -> r.getName().equals(name)).findFirst().orElse(null);
        return this.data.remove(rabbit);
    }
    public void removeSpecies(String species){
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }
    public Rabbit sellRabbit(String name){

        Rabbit rabbitToSell = data.stream().filter(rabbit -> rabbit.getName().equals(name)).findFirst().orElseThrow();

        rabbitToSell.setAvailable(false);
        return rabbitToSell;
    }
    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> rabbitsList = new ArrayList<>();

        for (Rabbit rabbit : data){
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                rabbitsList.add(rabbit);
            }
        }
        return rabbitsList;
    }
    public int count(){
        return this.data.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        List<Rabbit> rabbits = this.data.stream().filter(Rabbit::isAvailable).collect(Collectors.toList());

        sb.append(String.format("Rabbits available at %s:", getName()));
        rabbits.forEach(r -> {
            sb.append(System.lineSeparator());
            sb.append(r.toString());
        });
        return sb.toString();
    }
}
