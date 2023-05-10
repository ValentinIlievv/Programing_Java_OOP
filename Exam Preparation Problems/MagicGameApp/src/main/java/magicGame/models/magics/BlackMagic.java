package magicGame.models.magics;

public class BlackMagic extends MagicImpl{
    private static final int CAN_FIRE = 10;

    public BlackMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    int bulletsCountAccordingToMagic() {
        return CAN_FIRE;
    }
}
