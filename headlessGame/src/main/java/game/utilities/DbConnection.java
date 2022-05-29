package game.utilities;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class DbConnection {

    final Morphia morphia = new Morphia();

    private static final DbConnection instance = new DbConnection();

    public DbConnection() {}

    public static DbConnection getInstance()
    {
        return instance;
    }

    Datastore datastore = null;

    public Datastore getDatastore()
    {
        if (datastore == null) {
            connect();
        }
        return datastore;
    }

    public void connect()
    {

        // String connString = "mongodb+srv://40days:Etq4fCPhXYH3n.4@sysjm5.hxhte.mongodb.net/40daysInMalmo?retryWrites=true&w=majority";
        String connString = new Config().getProperty("mongoDbConnectionString");
        ConnectionString connectionString = new ConnectionString(connString);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        datastore = morphia.createDatastore(new MongoClient(), "gameDoTheWork");
        morphia.mapPackage("com.40-days-in-malmo");
        datastore.ensureIndexes();
    }

}