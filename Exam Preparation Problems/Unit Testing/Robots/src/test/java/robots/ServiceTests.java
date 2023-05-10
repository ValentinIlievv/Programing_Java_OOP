package robots;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTests {
    private Robot robot;
    private Service service;
    @Before
    public void setup(){
         this.robot = new Robot("Gosho");
         this.service = new Service("Name", 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetServiceThrowNullParam(){
        this.service = new Service(null, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacityThrowLessThanZeroParam(){
        this.service = new Service("Name", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotThrow(){
        this.service = new Service("Name", 1);
        Robot robot1 = new Robot("Pesho");
        this.service.add(this.robot);
        this.service.add(robot1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowNullParam(){
        this.robot = null;
        this.service.remove("Gosho");

    }
    @Test
    public void testRemove(){
        this.service = new Service("Name", 10);
        Robot robot1 = new Robot("Pesho");
        this.service.add(this.robot);
        this.service.add(robot1);

        this.service.remove("Pesho");

        Assert.assertEquals("Pesho", robot1.getName());
        Assert.assertEquals(1, this.service.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testForSaleThrowNullParam(){
        this.service.add(this.robot);
        this.service.forSale("Pesho");
    }
    @Test
    public void testForSale(){
        Robot robot1 = new Robot("Pesho");
        this.service.add(robot1);

        Robot robot2 = this.service.forSale("Pesho");

        Assert.assertEquals("Pesho", robot2.getName());
        Assert.assertEquals(false, robot2.isReadyForSale());
    }

    @Test
    public void testReport(){
      //  The robot %s is in the service %s!
        this.service.add(this.robot);

        Assert.assertEquals("The robot Gosho is in the service Name!", this.service.report());
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Name", this.service.getName());
    }
    @Test
    public void testCapacity(){
        Assert.assertEquals(10, this.service.getCapacity());
    }

}
