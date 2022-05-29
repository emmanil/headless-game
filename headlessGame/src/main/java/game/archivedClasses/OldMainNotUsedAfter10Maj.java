package game.archivedClasses;

import game.Backpack;
import game.Gameboard;
import game.Player;

public class OldMainNotUsedAfter10Maj {

    public static void main(String[] args) {
        Backpack backpack = new Backpack(1,0);

        Player survivor = new Player("Anna", backpack);


        System.out.println("Hello "+ survivor.getName());
        System.out.println("In your backpack you have "+backpack.getHowMuchRoom() + " space and "+ backpack.getHowMuchCash() + " cash.");

        /*
        System.out.println("You are standing on "+lillaTorg.nameOfLocation + " and there is "+lillaTorg.howManyNpcThatAreAtLocation+ " people here, their names are "+ populatedLillaTorg.getNamesOfNPCAtPopulatedLocation() +".");

        System.out.println("There is "+lillaTorg.howManyItemsOnTheGroundInLocation + " items on the ground, it is a "+ populatedLillaTorg.getTheNamesOfItemsOnLocation()  +". There are "+populatedLillaTorg.getHowManyQuestsOnLocation()+ " quests here.");

        System.out.println("If you want a quest you should talk to the people here, one of them knows about a quest. In the quest you have to "+ populatedLillaTorg.getInformationAboutQuest()+ ".");

        System.out.println("You said you want to talk to "+ populatedLillaTorg.theNonplayableCharactersAtLocation.get(0).name);
        */

        Gameboard theGameBoard = new Gameboard("theGameBoard", 10,10);

        theGameBoard.getAllLocationsOnGameBoard();

        theGameBoard.setNewLocationPlayerIsOn("A01");

        System.out.println();

        System.out.println("\n" + survivor.getName() +" you are on location "+ theGameBoard.getLocationPlayerIsOn());

        //no value to get yet

    }
}
