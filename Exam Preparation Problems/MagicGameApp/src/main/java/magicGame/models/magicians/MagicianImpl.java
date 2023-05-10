package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician{
    private String username;
    private int health;
    private int protection;
    private boolean isALive;
    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        this.isALive = true;
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0){
            throw  new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    private void setProtection(int protection) {
        if (protection < 0){
            throw  new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    private void setMagic(Magic magic) {
        if (magic == null){
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public boolean isAlive() {
        if (this.health > 0){
            this.isALive = true;
            return true;
        }
        this.isALive = false;
        return false;
    }

    @Override
    public void takeDamage(int points) {
        if (this.protection - points > 0){
            this.protection -= points;
        }
        else {
            int diff = this.protection - points;
            this.protection = 0;
            if (this.health - diff > 0){
                this.health -= diff;
            }
            else {
                this.health = 0;
                this.isALive = false;
            }

        }
    }
}
