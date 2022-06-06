package game;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.ArrayList;

@Entity
public class Backpack {

    @Id
    String id;

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

    public ArrayList<Item> getAllItems() {
        return allItems;
    }

    public String id() {
    return id;
    }

    public void addItem(Item sparklingFlower) {
        allItems.add(sparklingFlower);
    }
}
