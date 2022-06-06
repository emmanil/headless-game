package game;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private final String locationNumber;
    private int numRows;
    private int locationsPerRow;

    private List<Location> theGameBoard = new ArrayList<Location>();

    private Location locationTemp = new Location("99");

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

    public void setNewLocationPlayerIsOn(String locationNumberPlayerWantsToGoTo){
        for (int i = 0; i < theGameBoard.size(); i++) {
            if (theGameBoard.get(i).getLocationNumber().equals(locationNumberPlayerWantsToGoTo)){

            }
        }
        //below not done 9/5
      locationTemp.setLocationPlayerIsOn(locationNumberPlayerWantsToGoTo);
    }


}