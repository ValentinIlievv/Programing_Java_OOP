package catHouse.entities.houses;

import catHouse.common.ConstantMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        int sumSoftness = 0;
        for (Toy toy : this.toys){
            int softness = toy.getSoftness();
            sumSoftness += softness;
        }
        return sumSoftness;
    }

    @Override
    public void addCat(Cat cat) {

        if (this.cats.size() < capacity){
            this.cats.add(cat);
        }
        else {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat : this.cats){
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());
        sb.append("Cats: ");
        if (this.cats.size() == 0){
            sb.append("none") ;
        }else {

            int counter = 0;
            for (Cat cat : this.cats){
                String catName = cat.getName();
                counter++;

                if (counter == cats.size() - 1){
                    sb.append(catName);
                    counter = 0;
                }
                else {
                    sb.append(catName).append(" ");
                }
                sb.append(System.lineSeparator());
                sb.append("Toys: ");
                sb.append(this.toys.size());
                sb.append(" Softness: ").append(sumSoftness());
                sb.append(System.lineSeparator());


            }
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
