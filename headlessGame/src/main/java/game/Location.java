package game;

public class Location {

    String nameOfLocation;
    int howManyNpcThatAreAtLocation;
    int howManyItemsOnTheGroundInLocation;
    String whatSoundOnLocation;
    int howManyQuestsOnLocation;
    boolean playerIsAtLocation;
    int requiredLevelPlayerMustBeOnInOrderToEnterLocation;


    public Location(String nameOfLocation, int howManyNpcThatAreAtLocation, int howManyItemsOnTheGroundInLocation, String whatSoundOnLocation, int howManyQuestsOnLocation, boolean playerIsAtLocation, int requiredLevelPlayerMustBeOnInOrderToEnterLocation) {
        this.nameOfLocation = nameOfLocation;
        this.howManyNpcThatAreAtLocation = howManyNpcThatAreAtLocation;
        this.howManyItemsOnTheGroundInLocation = howManyItemsOnTheGroundInLocation;
        this.whatSoundOnLocation = whatSoundOnLocation;
        this.howManyQuestsOnLocation = howManyQuestsOnLocation;
        this.playerIsAtLocation = playerIsAtLocation;
        this.requiredLevelPlayerMustBeOnInOrderToEnterLocation = requiredLevelPlayerMustBeOnInOrderToEnterLocation;
    }


}
