package catHouse.entities.toys;

public class Ball extends BaseToy{
    private static final int SOFTNESS = 1;
    private static final int PRICE = 10;

    public Ball() {
        super(SOFTNESS, PRICE);
    }

    @Override
    public int getSoftness() {
        return this.SOFTNESS;
    }

    @Override
    public double getPrice() {
        return this.PRICE;
    }
}
