package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class HouseTests {
    public House house;
    public Cat cat;


    @Before
    public void setup(){
        this.house = new House("House", 10);
        this.cat = new Cat("Gosho");
    }
    @Test
    public void testGetName(){
        Assert.assertEquals("House", house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowNullParam(){
        this.house = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrowWhitespaceParam(){
        this.house = new House("  ", 10);
    }
    @Test
    public void testGetCapacity(){
        Assert.assertEquals(10, house.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowLessThanZeroParam(){
        this.house = new House("House", -1);
    }
    @Test
    public void testGetCount(){
        this.house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatThrowWhenHouseIsFull(){
        this.house = new House("House", 1);
        this.house.addCat(cat);
        Cat secondCat = new Cat("Pesho");
        this.house.addCat(secondCat);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatThrowNullParam(){
        this.cat = null;
        this.house.removeCat("Gosho");
    }

    @Test
    public void testRemoveCat(){
        this.house.addCat(this.cat);
        this.house.removeCat("Gosho");
        Assert.assertEquals(0, this.house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowNullParam(){

        this.cat = null;
        this.house.catForSale("Gosho");
    }
    @Test
    public void testCatForSale(){
        this.house.addCat(this.cat);
        this.house.catForSale("Gosho");
        Assert.assertEquals(false, this.cat.isHungry());
    }
    @Test
    public void testStatistics(){
        House house1 = new House("House1", 10);
        Cat pesho = new Cat("Pesho");
        Cat ivan = new Cat("Ivan");
        house1.addCat(pesho);
        house1.addCat(ivan);
        String statistics = house.statistics();

        Assert.assertEquals("The cat Pesho, Ivan is in the house House1!", house1.statistics());

    }
}
