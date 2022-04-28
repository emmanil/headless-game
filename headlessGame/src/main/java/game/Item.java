package game;

import java.util.ArrayList;

public class Item {

    String nameOfItem;
    String typeOfItem;
    Double priceOfItem;
    int stats;
    int howMuchSpaceItemTakes;

    ArrayList<Item> allItems = new ArrayList<>();

    public Item(String nameOfItem, String typeOfItem, Double priceOfItem, int stats, int howMuchSpaceItemTakes) {
        this.nameOfItem = nameOfItem;
        this.typeOfItem = typeOfItem;
        this.priceOfItem = priceOfItem;
        this.stats = stats;
        this.howMuchSpaceItemTakes = howMuchSpaceItemTakes;
    }

    public void createManyItem(){
    Item item1 = new Item("Sword", "weapon", 10.0, 10, 3);
        Item item2 = new Item("Sword", "weapon", 100.0, 100, 3);
        Item item3 = new Item("Sword", "weapon", 1000.0, 1000, 3);

        allItems.add(item1);
        allItems.add(item2);
        allItems.add(item3);
    }

    public ArrayList<Item> getThisManyItem(int howManyItemsOnTheGroundInLocation) {
    createManyItem();

    ArrayList<Item> howManyItem = new ArrayList<>();

        for (int i = 0; i < howManyItemsOnTheGroundInLocation; i++) {
            Item tempItem = allItems.get(i);
            howManyItem.add(tempItem);
        }
        return howManyItem;
    }

    public String getName() {
        return nameOfItem;
    }
}
