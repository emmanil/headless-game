package units;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import game.Item;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

public class ItemTest {

    Datastore datastore = DbConnection.getInstance().getDatastore();

    @BeforeEach
    void setUp() {
        Datastore datastore = DbConnection.getInstance().getDatastore();
    }

    //saves in collection item
    @Test
    void saveOneItem() {
        Item sparklingFlower = new Item("sparklingFlower", "food", "pretty to look at and when eaten it restores health ", 1, 1, 1, 0);
        sparklingFlower = datastore.save(sparklingFlower);

        Assertions.assertTrue(sparklingFlower instanceof Item);
    }

    @Test
    void saveManyItemsToDb() {
        Item pinkFlower = new Item("pinkFlower", "decoration", "pretty", 1, 1, 1, 0);
        Item whiteChocolate = new Item("white chocolate", "decoration", "pretty", 1, 1, 1, 0);
        datastore.save(pinkFlower);
        datastore.save(whiteChocolate);
    }

    @Test
    void getTheFirstItemFromDb() {
        Item itemSheGets = datastore.find(Item.class).stream().findFirst().get();
        Assertions.assertTrue(itemSheGets instanceof Item);
    }

    @Test
    void getItemByItemName() {
        String itemsName = "sparklingFlower";
        Item itemSheGets = datastore.find(Item.class).stream()
                .filter(item -> itemsName.equalsIgnoreCase(itemsName)).findFirst().orElse(null);
        Assertions.assertTrue(itemSheGets instanceof Item);
        Assertions.assertTrue("sparklingFlower".equals(itemSheGets.getName()));
    }

    @Test
    void getItemById() {
        String getAnExistingItemId = datastore.find(Item.class).stream().findFirst().get().id();
        Item itemSheGets = datastore.find(Item.class).stream().filter(item -> getAnExistingItemId.equalsIgnoreCase(getAnExistingItemId)).findFirst().orElse(null);

        Assertions.assertTrue(itemSheGets instanceof Item);
        Assertions.assertTrue(getAnExistingItemId.equals(itemSheGets.id()));
    }

    @Test
    void queryGetItemById() {
        Query<Item> query = datastore.find(Item.class);
        Item firstItem = query.first();
        firstItem = datastore.find(Item.class).filter(Filters.eq("id", firstItem.id())).first();
        Assertions.assertTrue(firstItem instanceof Item);
    }

    @Test
    void getAllItemsByACertainItemName() {

        String itemsName = "pinkFlower";
        long sizeOfList = datastore.find(Item.class).stream().filter(item -> item.getName().equals(itemsName)).count();
        System.out.println("sizeOfList = " + sizeOfList);

        List<Item> itemList = datastore.find(Item.class).stream().filter(item -> item.getName().equals(itemsName)).collect(Collectors.toList());

        Assertions.assertEquals((int) sizeOfList, itemList.size());
    }

    @Test
    void getAllItemsFromDb() {
        List<Item> items = datastore.find(Item.class).iterator().toList();
        Assertions.assertTrue(items.size() >= 0);

        long sizeOfItemCollection = datastore.find(Item.class).count();
        Assertions.assertTrue((int) sizeOfItemCollection == items.size());
    }

}
