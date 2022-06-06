package units;

import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import game.NPC;
import game.utilities.DbConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NPCTest {

    Datastore datastore = DbConnection.getInstance().getDatastore();

    @BeforeEach
    void setUp(){
        Datastore datastore = DbConnection.getInstance().getDatastore();
    }

    @Test
    void saveNewNPC(){
        NPC npc = new NPC();
        datastore.save(npc);
        Assertions.assertTrue(npc instanceof NPC);
    }

    @Test
    void getNPCbyId(){
        Query<NPC> query = datastore.find(NPC.class);
        NPC npc = query.first();
        npc = datastore.find(NPC.class).filter(Filters.eq("id", npc.id())).first();
        Assertions.assertTrue(npc instanceof NPC);
    }

    @Test
    void listNPCs(){
        List<NPC> npcs = datastore.find(NPC.class).iterator().toList();
        Assertions.assertTrue(npcs.size() >= 0);
    }
}
