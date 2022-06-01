package units;

import dev.morphia.Datastore;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbConnectionTest {

    Datastore datastore = DbConnection.getInstance().getDatastore();

    @BeforeEach
    void setUp() {
        Datastore datastore = DbConnection.getInstance().getDatastore();
    }

    @Test
    void connectToDatabase(){
        Datastore datastore = DbConnection.getInstance().getDatastore();
        Assertions.assertTrue(datastore instanceof Datastore);
    }

}
