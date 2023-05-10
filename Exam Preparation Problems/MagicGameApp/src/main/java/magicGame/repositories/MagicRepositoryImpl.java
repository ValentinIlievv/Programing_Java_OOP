package magicGame.repositories;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;
import magicGame.repositories.interfaces.MagicRepository;

import java.util.ArrayList;
import java.util.Collection;

public class MagicRepositoryImpl implements MagicRepository {
    private Collection<Magic> data;

    public MagicRepositoryImpl() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection getData() {
        return this.data;
    }

    @Override
    public void addMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC_REPOSITORY);
        }
        this.data.add(magic);
    }

    @Override
    public boolean removeMagic(Magic magic) {
        return this.data.remove(magic);
    }

    @Override
    public Object findByName(String name) {
        Magic magic = null;
        for (Magic magic1 : this.data){
            if (magic1.getName().equals(name)){
                magic = magic1;
            }
        }
        return magic;
    }
}
