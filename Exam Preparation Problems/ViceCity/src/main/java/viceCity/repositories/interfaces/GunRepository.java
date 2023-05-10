package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class GunRepository implements Repository{
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(Object model) {
        Gun gun = (Gun) model;
        if (find(gun.getName()) == null){
            this.models.add(gun);
        }
    }

    @Override
    public boolean remove(Object model) {
        Gun gun = (Gun) model;
        return this.models.remove(gun);
    }

    @Override
    public Object find(String name) {
        Gun gun = null;
        for (Gun gun1 : this.models){
            if (gun1.getName().equals(name)){
                gun = gun1;
            }
        }
        return gun;
    }
}
