package catHouse.entities.cat;

public class ShorthairCat extends BaseCat{
    private static final int INITIAL_KILOGRAMS = 7;
    private static final int INCREASE_KILOGRAMS_BY_BREED = 1;




    public ShorthairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    int increaseKilogramsByBreed() {
        return INCREASE_KILOGRAMS_BY_BREED;
    }

    @Override
    int initialKilograms() {
        return INITIAL_KILOGRAMS;
    }




}
