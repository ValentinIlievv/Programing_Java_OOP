package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {
    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }
    public boolean addChild(Child child){
        if (registry.size() < capacity){
            registry.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChild(String firstName){
        for (Child child : registry){
            String name = child.getFirstName();
            if (name.equals(firstName)){
                registry.remove(child);
                return true;
            }
        }
        return false;
    }
    public int getChildrenCount(){
        return registry.size();
    }
    public Child getChild(String firstName){
        Child childToReturn = null;
        for (Child child : registry){
            String name = child.getFirstName();
            if (name.equals(firstName)){
                childToReturn = child;
                break;
            }
        }
        return childToReturn;
    }
    public String registryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:", this.name)).append(System.lineSeparator());
        registry.sort(Comparator.comparing(child -> child.getLastName()));
        registry.sort(Comparator.comparing(child -> child.getFirstName()));
        registry.sort(Comparator.comparingInt(child -> child.getAge()));
        for (Child child : registry){
            sb.append("--").append(System.lineSeparator());
            sb.append("Child: ").append(child).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
