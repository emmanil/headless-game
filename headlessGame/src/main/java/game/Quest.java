package game;

import java.util.ArrayList;

public class Quest {

    String thingToDo;
    String whereToDoThing;
    String goToThisLocationWhenMissionIsDone;

    ArrayList<Quest> allQuests = new ArrayList<>();

    public Quest(String thingToDo, String whereToDoThing, String goToThisLocationWhenMissionIsDone) {
        this.thingToDo = thingToDo;
        this.whereToDoThing = whereToDoThing;
        this.goToThisLocationWhenMissionIsDone = goToThisLocationWhenMissionIsDone;
    }

    private void createManyQuests() {
        Quest quest1 = new Quest("get water ", "in västra hamnen", ", after you report to möllevångstorget");
        Quest quest2 = new Quest("get meat ", "in möllan", ", after you report to lilla torg");
        Quest quest3 = new Quest("kill monster ", "in västra hamnen", ", after you report to gustav adolfs torg");

        allQuests.add(quest1);
        allQuests.add(quest2);
        allQuests.add(quest3);
    }

    public ArrayList<Quest> getThisManyQuest(int howMany) {
    createManyQuests();

    ArrayList<Quest> howManyQuest = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {
            Quest tempQuest = allQuests.get(i);
            howManyQuest.add(tempQuest);
        }
    return howManyQuest;
    }

    public Quest getOneQuest(int howMany) {
        createManyQuests();
        ArrayList<Quest> howManyQuest = new ArrayList<>();
            Quest tempQuest = allQuests.get(0);
            howManyQuest.add(tempQuest);

        return tempQuest;
    }

    public String getThingToDo() {
        return thingToDo;
    }

    public String getWhereToDoThing() {
        return whereToDoThing;
    }

    public String getGoToThisLocationWhenMissionIsDone() {
        return goToThisLocationWhenMissionIsDone;
    }


}
