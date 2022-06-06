package units;

import dev.morphia.Datastore;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DbConnectionTest {

    Datastore datastore;

    @BeforeEach
    void setUp() {
        datastore = DbConnection.getInstance().getDatastore();
    }

    @Test
    void connectToDatabase(){
        datastore = DbConnection.getInstance().getDatastore();
        Assertions.assertTrue(datastore instanceof Datastore);
    }

}
