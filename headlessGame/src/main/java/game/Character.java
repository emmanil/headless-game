package game;

public abstract class Character {

    String name;
    int statsStrength;
    int statsIntelligence;
    int levelCharacterIsOn;

    public Character(String name) {
        this.name = name;
        this.statsStrength = 1;
        this.statsIntelligence = 1;
        this.levelCharacterIsOn = 1;
    }

    public String getName() {
        return name;
    }

    public int getStatsStrength() {
        return statsStrength;
    }

    public int getStatsIntelligence() {
        return statsIntelligence;
    }

    public int getLevelCharacterIsOn() {
        return levelCharacterIsOn;
    }
}
