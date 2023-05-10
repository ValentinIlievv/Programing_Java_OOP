package magicGame.repositories;

import magicGame.common.ExceptionMessages;
import magicGame.models.magicians.Magician;
import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicianRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicianRepositoryImpl implements MagicianRepository {
    private Collection<Magician> data;

    public MagicianRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.data;
    }

    @Override
    public void addMagician(Magician magician) {
        if (magician == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_REPOSITORY);
        }
    }

    @Override
    public boolean removeMagician(Magician magician) {
        return this.data.remove(magician);
    }

    @Override
    public Object findByUsername(String name) {
        Magician magician = null;
        for (Magician magician1 : this.data){
            if (magician1.getUsername().equals(name)){
                magician = magician1;
            }
        }
        return magician;
    }
}
