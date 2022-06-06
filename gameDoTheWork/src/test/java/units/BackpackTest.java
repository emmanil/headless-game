package units;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import game.Backpack;
import game.Item;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BackpackTest {

    Datastore datastore = DbConnection.getInstance().getDatastore();

    @BeforeEach
    void setUp(){
        Datastore datastore = DbConnection.getInstance().getDatastore();
    }

    @Test //saves in collection backpack
    void saveABackpack(){
        Backpack pinkBackpack = new Backpack(100,20);
        Item sparklingFlower = new Item();
        sparklingFlower = datastore.save(sparklingFlower);
        pinkBackpack.addItem(sparklingFlower);
        pinkBackpack = datastore.save(pinkBackpack);
        Assertions.assertTrue(pinkBackpack instanceof Backpack);
    }

    @Test
    void getTheFirstBackpackFromDb() {
        Backpack BackpackSheGets = datastore.find(Backpack.class).stream().findFirst().get();
        Assertions.assertTrue(BackpackSheGets instanceof Backpack);
    }

    @Test
    void queryGetBackpackByID(){
        Query<Backpack> query = datastore.find(Backpack.class);
        Backpack purpleBackpack = query.first();
        purpleBackpack = datastore.find(Backpack.class).filter(Filters.eq("id", purpleBackpack.id())).first();
        Assertions.assertEquals(1, purpleBackpack.getAllItems().size());
        Assertions.assertTrue(purpleBackpack instanceof Backpack);
    }

    @Test
    void getBackpackByBackpackId() {
        String backpackId = datastore.find(Backpack.class).stream().findFirst().get().id();
        Backpack BackpackSheGets = datastore.find(Backpack.class).stream() .filter(Backpack -> backpackId.equalsIgnoreCase(backpackId)).findFirst().orElse(null);
        Assertions.assertTrue(BackpackSheGets instanceof Backpack);
        Assertions.assertTrue(backpackId.equals(BackpackSheGets.id()));
    }

    @Test
    void getAllBackpacksFromDb(){
         List<Backpack> backpacks = datastore.find(Backpack.class).iterator().toList();
        Assertions.assertTrue(backpacks.size() >= 0);
        long sizeOfBackpackCollection = datastore.find(Backpack.class).count();
        Assertions.assertTrue((int) sizeOfBackpackCollection == backpacks.size());
    }

}
