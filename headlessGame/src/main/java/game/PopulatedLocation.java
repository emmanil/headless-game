package game;

import java.util.ArrayList;

public class PopulatedLocation {


    ArrayList<NonPlayableCharacter> theNonplayableCharactersAtLocation;
    ArrayList<Item> theItemsOnLocation;
    ArrayList<Quest> questsAtLocation;
    Tile tileNumber;

    NonPlayableCharacter tempNPC = new NonPlayableCharacter("t", false);


    Quest tempQuest = new Quest("t", "t", "t");

    public PopulatedLocation(Location location) {
        this.theNonplayableCharactersAtLocation = new ArrayList<>();
        this.theItemsOnLocation = new ArrayList<>();
        this.questsAtLocation = new ArrayList<>();

        //populate location with NPC
        if (location.howManyNpcThatAreAtLocation > 0) {
            this.theNonplayableCharactersAtLocation = tempNPC.getThisManyNPC(location.howManyNpcThatAreAtLocation);
        }

        //populate location with item
        if (location.howManyItemsOnTheGroundInLocation > 0) {
            Item tempItem = new Item("t", "t", 0.0, 0, 1);
            theItemsOnLocation = tempItem.getThisManyItem(location.howManyItemsOnTheGroundInLocation);
        }

        //populate location with quest
        if (location.howManyQuestsOnLocation > 0) {
            questsAtLocation = tempQuest.getThisManyQuest(location.howManyQuestsOnLocation);
        }

        //populate NPC with quest. Reactive programming used to initialize smallestValue.
        int smallestValue = (theNonplayableCharactersAtLocation.size() > questsAtLocation.size()) ? (smallestValue = theNonplayableCharactersAtLocation.size()) : (smallestValue = questsAtLocation.size());

        if (location.howManyQuestsOnLocation > 0) {

            for (int i = 0; i < location.howManyQuestsOnLocation; i++) {

                if (i <= smallestValue) {
                   // theNonplayableCharactersAtLocation.get(i).setQuest(questsAtLocation.get(i));
                    tempNPC.setQuest(questsAtLocation.get(i));

                }
            }
        }
    }

    public String getNamesOfNPCAtPopulatedLocation() {
        String namesOfNPC = "";
        for (int i = 0; i < theNonplayableCharactersAtLocation.size(); i++) {
            namesOfNPC = namesOfNPC + theNonplayableCharactersAtLocation.get(i).getName();

            if (i >= 0) {
                namesOfNPC = namesOfNPC + " at index "+i +"";

                if(i <  theNonplayableCharactersAtLocation.size()-1){
                    namesOfNPC = namesOfNPC + " and ";
                }
            }
        }
        return namesOfNPC;
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
}
