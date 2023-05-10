package viceCity.models.guns;

import viceCity.common.ExceptionMessages;

public abstract class BaseGun implements Gun{
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        this.canFire = true;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw  new NullPointerException(ExceptionMessages.NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0){
            throw new IllegalArgumentException(ExceptionMessages.BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        if (totalBullets < 0){
            throw new IllegalArgumentException(ExceptionMessages.TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        if (this.bulletsPerBarrel >= bulletsFireCount()){
            this.canFire = true;
            return true;
        }
        this.canFire = false;
        return false;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }
    abstract int bulletsFireCount();
    abstract int bulletsPerBarrelFinal();
    @Override
    public int fire() {
        if (this.canFire()){
            this.bulletsPerBarrel -= bulletsFireCount();
            if (this.bulletsPerBarrel <= bulletsFireCount()){
                if (this.totalBullets >= bulletsPerBarrelFinal()){
                    this.totalBullets -= bulletsPerBarrelFinal();
                    this.bulletsPerBarrel = bulletsPerBarrelFinal();
                }
                return bulletsFireCount();
            }
        }

        return 0;
    }
}
