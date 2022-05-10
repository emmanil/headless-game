package game;

public class Backpack {

    private int howMuchRoom;
    private double howMuchCash;

    public Backpack(int howMuchRoom, double howMuchCash) {
        this.howMuchRoom = 1;
        this.howMuchCash = 0;
    }

    public int getHowMuchRoom() {
        return howMuchRoom;
    }

    public double getHowMuchCash() {
        return howMuchCash;
    }
}
