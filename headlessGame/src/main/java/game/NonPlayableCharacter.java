package game;

import java.util.ArrayList;


public class NonPlayableCharacter extends Character {

    private boolean hasQuestToOffer;

    private Quest quest;

    ArrayList<NonPlayableCharacter> allNpc = new ArrayList<>();

    Quest tempQuest = new Quest("t", "t", "t");

    public NonPlayableCharacter(String name, boolean hasQuestToOffer) {
        super(name);
        this.hasQuestToOffer = hasQuestToOffer;
        if (hasQuestToOffer){
            this.quest = tempQuest.getOneQuest(1);
        }
        this.quest = null;
    }


    public void createManyNPC() {
        NonPlayableCharacter NPC1 = new NonPlayableCharacter("Lilleman", true);
        NonPlayableCharacter NPC2 = new NonPlayableCharacter("Lillebror", false);
        NonPlayableCharacter NPC3 = new NonPlayableCharacter("Gubben", true);

        allNpc.add(NPC1);
        allNpc.add(NPC2);
        allNpc.add(NPC3);
    }

    public ArrayList<NonPlayableCharacter> getThisManyNPC(int howMany) {
        createManyNPC();
        ArrayList<NonPlayableCharacter> howmanyNPC = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            NonPlayableCharacter tempNPC = allNpc.get(i);
            howmanyNPC.add(tempNPC);
        }
        return howmanyNPC;
    }

    public String getInformationAboutTheQuestAtIndexZero() {

        if (quest == null){
            return "There is no quest here.";
        }

        return quest.getThingToDo() + quest.getWhereToDoThing() + quest.getGoToThisLocationWhenMissionIsDone();
    }

    public Quest getQuest() {
        return this.quest;
    }


    public void setQuest(Quest quest) {
        if (this.quest == null) {
            this.quest = null;
        }
        this.quest = quest;
    }


}
