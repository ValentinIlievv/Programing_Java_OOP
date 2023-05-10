package RawDataEx_04;

public class Car {
    private String model;
    private Engine engine;
    private  Cargo cargo;
    private Tire tire;

    public Car(String model, Engine engine, Cargo cargo, Tire tire) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire = tire;
    }

    public void printFragile(){
        if (this.tire.getPressure()){
            System.out.println(this.model);
        }
    }
    public void printFlammable(){
        if (this.engine.getEnginePower() > 250){
            System.out.println(this.model);
        }
    }
}
