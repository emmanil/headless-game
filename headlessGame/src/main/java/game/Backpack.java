package game;

import java.util.ArrayList;

public class Backpack {

    private int howMuchRoom;
    private double howMuchCash;
    ArrayList<Item> allItems = new ArrayList<>();

    public Backpack(int howMuchRoom, double howMuchCash) {
        this.howMuchRoom = 1;
        this.howMuchCash = 0;
        this.allItems = new ArrayList<>();
    }

    public int getHowMuchRoom() {
        return howMuchRoom;
    }

    public double getHowMuchCash() {
        return howMuchCash;
    }
}
