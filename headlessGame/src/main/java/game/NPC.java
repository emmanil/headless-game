package game;

import dev.morphia.annotations.Entity;

import java.util.ArrayList;

@Entity
public class NPC extends Character {

    private boolean hasQuestToOffer;

    private Quest quest;

    ArrayList<NPC> allNpc = new ArrayList<>();

    Quest tempQuest = new Quest("t", "t", "t");

    public NPC(String name, boolean hasQuestToOffer) {
        super(name);
        this.hasQuestToOffer = hasQuestToOffer;
        if (hasQuestToOffer){
            this.quest = tempQuest.getOneQuest(1);
        }
        this.quest = null;
    }


    public void createManyNPC() {
        NPC NPC1 = new NPC("Lilleman", true);
        NPC NPC2 = new NPC("Lillebror", false);
        NPC NPC3 = new NPC("Gubben", true);

        allNpc.add(NPC1);
        allNpc.add(NPC2);
        allNpc.add(NPC3);
    }

    public ArrayList<NPC> getThisManyNPC(int howMany) {
        createManyNPC();
        ArrayList<NPC> howmanyNPC = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            NPC tempNPC = allNpc.get(i);
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
