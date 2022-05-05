
package game;

public class Tile implements Comparable<Tile> {
    private final String tileNumber;
    boolean playerIsOnTile;

    public Tile(String tileNumber) {
        this.tileNumber = tileNumber;
        this.playerIsOnTile = false;
    }

    @Override
    public int compareTo(Tile tile) {
        return this.tileNumber.compareToIgnoreCase(tile.getTileNumber());
    }

    public String getTileNumber() {
        return tileNumber;
    }

    public int getTheTilesRowNumber() {
        return tileNumber.indexOf(0);
    }
}
