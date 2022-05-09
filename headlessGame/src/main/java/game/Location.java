package game;

import java.util.ArrayList;

public class Location implements Comparable<Location> {

    String locationNumber;
    String nameOfLocation;
    int howManyNpcThatAreAtLocation;
    int howManyItemsOnTheGroundInLocation;
    String whatSoundOnLocation;
    int howManyQuestsOnLocation;
    boolean playerIsAtLocation;
    int requiredLevelPlayerMustBeOnInOrderToEnterLocation;

    ArrayList<NonPlayableCharacter> theNonplayableCharactersAtLocation;
    ArrayList<Item> theItemsOnLocation;
    ArrayList<Quest> questsAtLocation;

    NonPlayableCharacter tempNPC = new NonPlayableCharacter("t", false);
    Quest tempQuest = new Quest("t", "t", "t");


    public Location(String locationNumber) {
        this.locationNumber = locationNumber;
        this.nameOfLocation = nameOfLocation;
        this.howManyNpcThatAreAtLocation = howManyNpcThatAreAtLocation;
        this.howManyItemsOnTheGroundInLocation = howManyItemsOnTheGroundInLocation;
        this.whatSoundOnLocation = whatSoundOnLocation;
        this.howManyQuestsOnLocation = howManyQuestsOnLocation;
        this.playerIsAtLocation = playerIsAtLocation;
        this.requiredLevelPlayerMustBeOnInOrderToEnterLocation = requiredLevelPlayerMustBeOnInOrderToEnterLocation;

        this.theNonplayableCharactersAtLocation = new ArrayList<>();
        this.theItemsOnLocation = new ArrayList<>();
        this.questsAtLocation = new ArrayList<>();

        //populate location with NPC
        if (howManyNpcThatAreAtLocation > 0) {
            this.theNonplayableCharactersAtLocation = tempNPC.getThisManyNPC(howManyNpcThatAreAtLocation);
        }

        //populate location with item
        if (howManyItemsOnTheGroundInLocation > 0) {
            Item tempItem = new Item("t", "t", 0.0, 0, 1);
            theItemsOnLocation = tempItem.getThisManyItem(howManyItemsOnTheGroundInLocation);
        }

        //populate location with quest
        if (howManyQuestsOnLocation > 0) {
            questsAtLocation = tempQuest.getThisManyQuest(howManyQuestsOnLocation);
        }

        //populate NPC with quest. Reactive programming used to initialize smallestValue.
        int smallestValue = (theNonplayableCharactersAtLocation.size() > questsAtLocation.size()) ? (smallestValue = theNonplayableCharactersAtLocation.size()) : (smallestValue = questsAtLocation.size());

        if (howManyQuestsOnLocation > 0) {

            for (int i = 0; i < howManyQuestsOnLocation; i++) {

                if (i <= smallestValue) {
                    // theNonplayableCharactersAtLocation.get(i).setQuest(questsAtLocation.get(i));
                    tempNPC.setQuest(questsAtLocation.get(i));

                }
            }
        }

    }


    public void setAllLocationDetails(String numberOfLocationToChange, int howManyNpcThatAreAtLocation, int howManyItemsOnTheGroundInLocation, String whatSoundOnLocation, int howManyQuestsOnLocation, int requiredLevelPlayerMustBeOnInOrderToEnterLocation) {

        this.howManyNpcThatAreAtLocation = howManyNpcThatAreAtLocation;
        this.howManyItemsOnTheGroundInLocation = howManyItemsOnTheGroundInLocation;
        this.whatSoundOnLocation = whatSoundOnLocation;
        this.howManyQuestsOnLocation = howManyQuestsOnLocation;
        this.requiredLevelPlayerMustBeOnInOrderToEnterLocation = requiredLevelPlayerMustBeOnInOrderToEnterLocation;
    }

    public String getLocationNumber() {
        return locationNumber;
    }

    public int getTheLocationsRowNumber() {
        return locationNumber.indexOf(0);
    }

    public void setLocationPlayerIsOn(String locationNumber) {

        //hitta location med locationNumber
        //TODO
        //på den sätta att playerIsAtLocation = true.
    }


    public String getTheNamesOfItemsOnLocation() {
        String namesOfItems = "";
        for (int i = 0; i < theItemsOnLocation.size(); i++) {
            namesOfItems = namesOfItems + theItemsOnLocation.get(i).getName();
            if (i > 0) {
                namesOfItems = namesOfItems + " ";
            }
        }
        return namesOfItems;
    }

    public int getHowManyQuestsOnLocation() {
        return questsAtLocation.size();
    }

    public String getInformationAboutQuest() {

        return tempNPC.getInformationAboutTheQuestAtIndexZero();
    }


    @Override
    public int compareTo(Location location) {
        return this.locationNumber.compareToIgnoreCase(location.getLocationNumber());
    }
}
