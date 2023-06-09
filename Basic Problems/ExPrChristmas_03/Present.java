package ExPrChristmas_03;

public class Present {
    public  String name;
    public  double weight;
    public String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString(){

        return String.format("Present %s (%.2f) for a %s`", this.name, this.weight, this.gender);
    }
}
