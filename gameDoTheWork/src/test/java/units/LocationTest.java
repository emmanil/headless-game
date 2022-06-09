package units;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import game.Location;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LocationTest {

    Datastore datastore;

    @BeforeEach
    void setUp() {
        datastore = DbConnection.getInstance().getDatastore();
    }

    //saves in collection Location
    @Test
    void saveOneLocation() {
        Location lillaTorg = new Location("A01");
        lillaTorg.setName("lillaTorg");
        lillaTorg = datastore.save(lillaTorg);

        Assertions.assertTrue(lillaTorg instanceof Location);
    }

    @Test
    void saveManyLocationsToDb() {
        Location lillaTorg = new Location();
        lillaTorg.setName("lilla Torg");
        Location Mollan = new Location();
        datastore.save(lillaTorg);
        datastore.save(Mollan);
    }

    @Test
    void getTheFirstLocationFromDb() {
        Location LocationSheGets = datastore.find(Location.class).stream().findFirst().get();
        Assertions.assertTrue(LocationSheGets instanceof Location);
    }

    @Test
    void getLocationByLocationName() {
        String LocationsName = "lillaTorg";
        Location LocationSheGets = datastore.find(Location.class).filter(Filters.eq("nameOfLocation", LocationsName)).first();
        Assertions.assertTrue(LocationSheGets instanceof Location);
        Assertions.assertEquals("pinkFlower",LocationSheGets.getName());
    }

    @Test
    void getLocationById() {
        String getAnExistingLocationId = datastore.find(Location.class).stream().findFirst().get().id();
        Location LocationSheGets = datastore.find(Location.class).stream().filter(Location -> getAnExistingLocationId.equalsIgnoreCase(getAnExistingLocationId)).findFirst().orElse(null);

        Assertions.assertTrue(LocationSheGets instanceof Location);
        Assertions.assertTrue(getAnExistingLocationId.equals(LocationSheGets.id()));
    }

    @Test
    void queryGetLocationById() {
        Query<Location> query = datastore.find(Location.class);
        Location firstLocation = query.first();
        firstLocation = datastore.find(Location.class).filter(Filters.eq("id", firstLocation.id())).first();
        Assertions.assertTrue(firstLocation instanceof Location);
    }


    @Test
    void getAllLocationsByACertainLocationName() {

        String nameOfLocation = "pinkFlower";
        long sizeOfList = datastore.find(Location.class).filter(Filters.eq("nameOfLocation", nameOfLocation)).stream().count();
        System.out.println("sizeOfList = " + sizeOfList);

        List<Location> LocationList = datastore.find(Location.class).filter(Filters.eq("nameOfLocation", nameOfLocation)).stream().toList();

        Assertions.assertEquals((int) sizeOfList, LocationList.size());
    }

    @Test
    void getAllLocationsFromDb() {
        List<Location> Locations = datastore.find(Location.class).iterator().toList();
        Assertions.assertTrue(Locations.size() >= 0);

        long sizeOfLocationCollection = datastore.find(Location.class).count();
        Assertions.assertTrue((int) sizeOfLocationCollection == Locations.size());
    }

}
