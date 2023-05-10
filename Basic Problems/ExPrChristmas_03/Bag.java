package ExPrChristmas_03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    public List<Present> data;
    public String color;
    public int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count(){
        return this.data.size();
    }
    public void add (Present present){
        if (data.size() <= capacity){
            data.add(present);
        }
    }
    public boolean remove (String name){

        return this.data.removeIf(p -> p.getName().equals(name));
    }
    public Present heaviestPresent(){

        return this.data.stream().sorted((l, r) -> Double.compare(r.getWeight(), l.getWeight())).findFirst().get();
    }
    public Present getPresent(String name){
        Present present = null;
        for (int i = 0; i < data.size(); i++) {
            String currentName = data.get(i).getName();

            if (currentName.equals(name)){
                present = data.get(i);
            }

        }
        return present;
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(" bag contains: ").append(System.lineSeparator());

        for (Present present : data){
            sb.append(present.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
