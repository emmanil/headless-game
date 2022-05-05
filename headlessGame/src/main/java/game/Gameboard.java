package game;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private String tileNumber;
    private int numRows;
    private int tilesPerRow;

    public List<Tile> theGameBoard = new ArrayList<>();


    public Gameboard(String tileNumber, int numRows, int tilesPerRow) {
        this.tileNumber = tileNumber;

        int lastRow = 'A' + (numRows - 1);

        for (char row = 'A'; row <= lastRow; row++) {

            for (int seatNum = 1; seatNum <= tilesPerRow; seatNum++) {
                Tile tile = new Tile(row + String.format("%02d", seatNum));
                theGameBoard.add(tile);
            }
        }
    }

    // for testing purposes
    public void getAllTiles() {
        for (Tile tile : theGameBoard) {
            System.out.print(tile.getTileNumber() + " ");
        }
    }

    public ArrayList<String> getPossibleExitsFromTilePlayersIsOn(String nameOfTheTilePlayerIsOn) {
        ArrayList<String> nameOfTilesThePlayerCanGoTo = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            //go up
            //left
            //right
            //down
        }
        return nameOfTilesThePlayerCanGoTo;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getTilesPerRow() {
        return tilesPerRow;
    }

    public String getTileNumberOfTheTilePlayerIsOn() {
        String tileThatPlayerIsOn = "";
        for (Tile tile : theGameBoard) {
            if (tile.playerIsOnTile == true) {
                tileThatPlayerIsOn = tile.getTileNumber();
            }
        }
        return tileThatPlayerIsOn;
    }

    public void setTileThePlayerIsOn(String tileNumber){
        if (theGameBoard.contains(tileNumber)){

        }
    }

}