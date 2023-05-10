package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LongHairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        if (type.equals("ShortHouse") ){
            House house = new ShortHouse(name);
            this.houses.add(house);
            }

        else if (type.equals("LongHouse")){
            House house = new LongHouse(name);
            this.houses.add(house);
        }
        else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        if (type.equals("Ball")){
            Toy toy = new Ball();
            toys.buyToy(toy);
        }
        else if (type.equals("Mouse")){
            Toy toy = new Mouse();
            toys.buyToy(toy);
        }
        else {
            throw  new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = null;
        for (House house1 : this.houses){
            if (house1.getName().equals(houseName)){
                house = house1;
            }
        }
        Toy toy = this.toys.findFirst(toyType);
        if (house != null && toy != null){
            house.buyToy(toy);
            toys.removeToy(toy);
        }
        else if (toy == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        if (catType.equals("ShorthairCat")){
            cat = new ShorthairCat(catName, catBreed, price);

        }
        else if (catType.equals("LonghairCat")){
            cat = new LongHairCat(catName, catBreed, price);
        }
        else {
            throw  new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        House house = null;
        for (House house1 : this.houses){
            if (house1.getName().equals(houseName)){
                house = house1;
            }
        }
        String houseType = house.getClass().getSimpleName();


        if (houseType.contains("Long") && catType.contains("Long")){
            house.addCat(cat);
        }
        else if (houseType.contains("Short") && catType.contains("Short")){
            house.addCat(cat);
        }
        else {
            return ConstantMessages.UNSUITABLE_HOUSE;
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = null;
        for (House house1 : this.houses){
            if (house1.getName().equals(houseName)){
                house = house1;
            }
        }
        if (house != null){
            house.feeding();
        }
        int catsCount = house.getCats().size();

        return String.format(ConstantMessages.FEEDING_CAT, catsCount);
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = null;
        for (House house1 : this.houses){
            if (house1.getName().equals(houseName)){
                house = house1;
            }
        }
        double sum = 0;
        if (house != null){
            Collection<Cat> cats = house.getCats();
            Collection<Toy> toys = house.getToys();
            for (Cat cat : cats){
                sum += cat.getPrice();
            }
            for (Toy toy : toys){
                sum += toy.getPrice();
            }
        }
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, sum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : this.houses){
            sb.append(house.getStatistics()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
