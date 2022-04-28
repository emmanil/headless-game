package game;

public class Main {

    public static void main(String[] args) {
        Backpack backpack = new Backpack(1,0);

        PlayableCharacter survivor = new PlayableCharacter("Anna", backpack);

        //the basics
        Location lillaTorg = new Location("Lilla torg", 1, 1, "heavily breathing drunk people", 1, true, 0);

        //the populated location
        PopulatedLocation populatedLillaTorg = new PopulatedLocation(lillaTorg);

        System.out.println("Hello "+ survivor.getName());
        System.out.println("In your backpack you have "+backpack.howMuchRoom + " space and "+ backpack.howMuchCash + " cash.");

        System.out.println("You are standing on "+lillaTorg.nameOfLocation + " and there is "+lillaTorg.howManyNpcThatAreAtLocation+ " people here, their names are "+ populatedLillaTorg.getNamesOfNPCAtPopulatedLocation() +".");

        System.out.println("There is "+lillaTorg.howManyItemsOnTheGroundInLocation + " items on the ground, it is a "+ populatedLillaTorg.getTheNamesOfItemsOnLocation()  +". There are "+populatedLillaTorg.getHowManyQuestsOnLocation()+ " quests here.");

        System.out.println("If you want a quest you should talk to the people here, one of them knows about a quest. In the quest you have to "+ populatedLillaTorg.getInformationAboutQuest()+ ".");


    }
}
