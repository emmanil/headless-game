package game;

public class Player extends Character {

    Quest nameOfPlayersCurrentQuest;
    Backpack playersBackpack;


    public Player(String name, Backpack playersBackpack) {
        super(name);

        this.nameOfPlayersCurrentQuest = new Quest("", "", "");;
        this.playersBackpack = playersBackpack;
    }


    public Quest getNameOfPlayersCurrentQuest() {
        return nameOfPlayersCurrentQuest;
    }

    public Backpack getPlayersBackpack() {
        return playersBackpack;
    }

}
