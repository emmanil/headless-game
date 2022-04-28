package game;

public class Backpack {

    int howMuchRoom;
    double howMuchCash;

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
