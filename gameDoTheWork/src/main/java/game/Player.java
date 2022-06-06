package game;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

@Entity
public class Player extends Character {

    @Id
    protected String id;
    protected Quest nameOfPlayersCurrentQuest;
    protected Backpack playersBackpack;
    protected int level;

    public Player(String name, Backpack playersBackpack) {
        super(name);
        this.nameOfPlayersCurrentQuest = new Quest("", "", "");
        ;
        this.playersBackpack = playersBackpack;
    }

    public Player() {
    }


    public Quest getNameOfPlayersCurrentQuest() {
        return nameOfPlayersCurrentQuest;
    }

    public Backpack getPlayersBackpack() {
        return playersBackpack;
    }

    public void setName(String emma) {
        this.name = name;
    }

    public String id() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }
}
