package game;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private final String locationNumber;
    private int numRows;
    private int locationsPerRow;

    private Gameboard theGameBoard = new Gameboard("theGameBoard", 10,10);

    List<Location> gameBoard = new ArrayList<Location>();

    //private Location locationTemp = new Location("99");
    //Class location = locationTemp.getClass();

    public Gameboard(String locationNumber, int numRows, int locationsPerRow) {
        this.locationNumber = locationNumber;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {

            for (int locationNum = 1; locationNum <= locationsPerRow; locationNum++) {
                Location tile = new Location(row + String.format("%02d", locationNum));
                theGameBoard.add(tile);
            }
        }
    }

    // for testing purposes
    public void getAllLocationsOnGameBoard() {
        for (Location location : theGameBoard) {
            System.out.print(location.getLocationNumber() + " ");
        }
    }

    public Location getLocationPlayerIsOn() {
        Location location = null;
        //TODO
        return location;
    }

    public ArrayList<String> getPossibleExitsFromLocationPlayersIsOn(String nameOfTheLocationPlayerIsOn) {
        ArrayList<String> nameOfLocationsThePlayerCanGoTo = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            //go up
            //left
            //right
            //down
        }
        return nameOfLocationsThePlayerCanGoTo;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getLocationsPerRow() {
        return locationsPerRow;
    }

    public void setNewLocationPlayerIsOn(Gameboard gameboard, String locationNumberPlayerWantsToGoTo){


    }


    public Gameboard getTheGameBoard() {
        return theGameBoard;
    }


}