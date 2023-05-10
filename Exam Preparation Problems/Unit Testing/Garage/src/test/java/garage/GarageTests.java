package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private Car porsche;
    private Car mercedes;
    private Car audi;

    @Before
    public void setup(){
        garage = new Garage();
        porsche = new Car("Porsche", 250, 2000);
        mercedes = new Car("Mercedes", 220, 1800);
        audi = new Car("Audi", 200, 1500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarThrowNullParam(){
        Car car = null;
        garage.addCar(car);
    }

    @Test
    public void testAddCar(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);

        List<Car> cars = new ArrayList<>();
        cars.add(porsche);
        cars.add(mercedes);
        cars.add(audi);

        Assert.assertEquals(garage.getCars(), cars);
    }
    @Test
    public void testGetCars(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);

        List<Car> cars = new ArrayList<>();
        cars.add(porsche);
        cars.add(mercedes);
        cars.add(audi);

        Assert.assertEquals(garage.getCars(), cars);
    }
    @Test
    public void testGetCount(){
        garage.addCar(porsche);
        garage.addCar(mercedes);

        Assert.assertEquals(2, garage.getCount());
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);

        List<Car> cars = garage.findAllCarsWithMaxSpeedAbove(230);

        Assert.assertEquals(1, cars.size());

        Assert.assertEquals(porsche, cars.get(0));

    }
    @Test
    public void tesGetTheMostExpensiveCar(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);

        Car theMostExpensiveCar = garage.getTheMostExpensiveCar();

        Assert.assertEquals(porsche, theMostExpensiveCar);
    }
    @Test
    public void testFindAllCarsByBrand(){
        garage.addCar(porsche);
        garage.addCar(mercedes);
        garage.addCar(audi);

        List<Car> cars = garage.findAllCarsByBrand("Mercedes");

        Assert.assertEquals(mercedes,cars.get(0));
    }
}