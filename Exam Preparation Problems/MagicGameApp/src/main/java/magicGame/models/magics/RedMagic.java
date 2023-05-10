package magicGame.models.magics;

public class RedMagic extends MagicImpl{
    private static final int CAN_FIRE = 1;

    public RedMagic(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    int bulletsCountAccordingToMagic() {
        return CAN_FIRE;
    }
}
