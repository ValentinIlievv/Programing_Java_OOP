package magicGame.core;

import magicGame.common.ExceptionMessages;
import magicGame.common.OutputMessages;
import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.MagicRepositoryImpl;
import magicGame.repositories.MagicianRepositoryImpl;

import java.util.Collection;
import java.util.stream.Collectors;


public class ControllerImpl implements Controller {
    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        if (type.equals("RedMagic")){
            Magic magic = new RedMagic(name, bulletsCount);
            this.magics.addMagic(magic);
        }
        else if (type.equals("BlackMagic")){
            Magic magic = new BlackMagic(name, bulletsCount);
            this.magics.addMagic(magic);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGIC_TYPE);
        }
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        if (type.equals("Wizard")){
            Magic magic = (Magic) this.magics.findByName(magicName);
            if (magic == null){
                throw  new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
            }
            Magician magician = new Wizard(username, health, protection, magic);
        }
        else if (type.equals("BlackWidow")){
            Magic magic = (Magic) this.magics.findByName(magicName);
            if (magic == null){
                throw  new NullPointerException(ExceptionMessages.MAGIC_CANNOT_BE_FOUND);
            }
            Magician magician = new BlackWidow(username, health, protection, magic);
        }
        else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_TYPE);
        }
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        Collection<Magician> magiciansIsAlive = this.magicians.getData().stream().filter(Magician::isAlive)
                .collect(Collectors.toList());
        return region.start(magiciansIsAlive);
    }

    @Override
    public String report() {
        return null;
    }
}
