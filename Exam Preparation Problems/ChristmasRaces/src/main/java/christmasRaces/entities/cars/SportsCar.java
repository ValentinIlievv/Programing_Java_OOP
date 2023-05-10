package christmasRaces.entities.cars;

import christmasRaces.common.ExceptionMessages;

public class SportsCar extends BaseCar{
    private final static double DEFAULT_CUBIC_CENTIMETERS = 3000;
    private final static int MIN_HORSEPOWER = 250;
    private final static int MAX_HORSEPOWER = 450;



    public SportsCar(String model, int horsePower) {
        super(model, horsePower,DEFAULT_CUBIC_CENTIMETERS);
    }

    @Override
    protected void checkHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER){
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_HORSE_POWER, horsePower));
        }
    }
}
