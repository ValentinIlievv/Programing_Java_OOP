package SpeedRacingEx_03;

import java.security.PrivateKey;

public class Car {

    private String model;
    private double fuelAmount;
    private  double fuelCostPerKm;
    private int distanceTraveled;

    public Car (String model, double fuelAmount, double fuelCostPerKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }
    public boolean drive(int kmToDrive){
        double fuelNeed = kmToDrive * this.fuelCostPerKm;

        if (fuelNeed <= fuelAmount){
            this.fuelAmount -= fuelNeed;
            this.distanceTraveled += kmToDrive;
            return true;
        }

        return false;
    }

    @Override
    public String toString (){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
