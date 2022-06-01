package game.utilities;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class DbConnection {

    private static final DbConnection instance = new DbConnection();

    public DbConnection() {
    }

    public static DbConnection getInstance() {
        return instance;
    }

    Datastore datastore = null;

    public Datastore getDatastore() {
        if (datastore == null) {
            connect();
        }
        return datastore;
    }

    public void connect() {

        // String connString = "mongodb+srv://~
        String connString = new Config().getProperty("mongoDbConnectionString");
        ConnectionString connectionString = new ConnectionString(connString);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        datastore = Morphia.createDatastore(MongoClients.create(settings), "gameDoTheWork");
        datastore.getMapper().mapPackage("com.headless-game-vt2022.doTheWorkGame");
        datastore.ensureIndexes();
    }

}