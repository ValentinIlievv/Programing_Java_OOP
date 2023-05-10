package catHouse.entities.cat;

public class LongHairCat extends BaseCat{
    private static final int INITIAL_KILOGRAMS = 9;
    private static final int INCREASE_KILOGRAMS_BY_BREED = 3;


    public LongHairCat(String name, String breed, double price) {
        super(name, breed, price);
    }

    @Override
    int increaseKilogramsByBreed() {
        return INCREASE_KILOGRAMS_BY_BREED;
    }

    @Override
   public int initialKilograms() {
        return INITIAL_KILOGRAMS;
    }


}


