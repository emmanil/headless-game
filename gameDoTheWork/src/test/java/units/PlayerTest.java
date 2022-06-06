package units;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import game.Player;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerTest {

    Datastore datastore;

    @BeforeEach
    void setUp(){
        datastore = DbConnection.getInstance().getDatastore();
    }

    @Test
    void saveNewPlayer(){
        Player player = new Player();
        player.setName("Emma");
        player = datastore.save(player);
        Assertions.assertTrue(player instanceof Player);
    }

    @Test
    void getPlayerByID(){
        Query<Player> query = datastore.find(Player.class);
        Player player = query.first();
        player = datastore.find(Player.class).filter(Filters.eq("id", player.id())).first();
        Assertions.assertTrue(player instanceof Player);
    }

    @Test
    void listPlayers(){
        List<Player> players = datastore.find(Player.class).iterator().toList();
        Assertions.assertTrue(players.size() >= 0);
    }

}