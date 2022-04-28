package game;

public class PlayableCharacter extends Character {

    Quest nameOfPlayersCurrentQuest;
    Backpack playersBackpack;


    public PlayableCharacter(String name, Backpack playersBackpack) {
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
