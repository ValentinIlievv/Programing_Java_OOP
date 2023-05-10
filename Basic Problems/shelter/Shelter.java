package shelter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public List<Animal> data(){
        return this.data;
    }
    public void add(Animal animal){
        if (this.data.size() < this.capacity){
            this.data.add(animal);
        }
    }
    public boolean remove(String name){

        return this.data.removeIf(animal -> animal.getName().equals(name));
    }
    public Animal getAnimal(String name, String caretaker){
        Animal animalToGet = this.data.stream().filter(animal -> animal.getName().equals(name)).
                filter(animal -> animal.getCaretaker().equals(caretaker)).findFirst().orElse(null);
        return animalToGet;
    }
    public Animal getOldestAnimal(){
        Animal oldestAnimal = null;
        int oldestAge = 0;
        for (Animal animal : this.data){
            int currentAge = animal.getAge();
            if (currentAge > oldestAge){
                oldestAge = currentAge;
                oldestAnimal = animal;
            }
        }
        return oldestAnimal;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The shelter has the following animals:").append(System.lineSeparator());

        for (Animal animal : this.data){
            String name = animal.getName();
            String caretaker = animal.getCaretaker();

            sb.append(String.format("%s %s", name, caretaker)).append(System.lineSeparator());
        }

        return sb.toString();
    }

}
