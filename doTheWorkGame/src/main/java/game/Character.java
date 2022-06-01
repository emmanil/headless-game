package game;

public abstract class Character {

    String name;
    int strength;
    int levelCharacterIsOn;

    public Character(){
        this.name = name;
    }

    public Character(String name) {
        this.name = name;
        this.strength = 1;
        this.levelCharacterIsOn = 1;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getLevelCharacterIsOn() {
        return levelCharacterIsOn;
    }
}
