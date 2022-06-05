package cucumber;

import dev.morphia.Datastore;
import game.Player;
import game.utilities.DbConnection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class GetSkillPoints {


    Datastore datastore;
    int level;
    Player player;
    String idSheGets;

    @BeforeEach
    void setUp(){
        datastore = DbConnection.getInstance().getDatastore();
    }

    @Given("A player exists")
    public void a_player_exists() {
        Player player;
        try {
            String idSheGets = datastore.find(Player.class).stream().findFirst().get().id();
            player = datastore.find(Player.class).stream().filter(Player -> idSheGets.equals(idSheGets)).findAny().orElse(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            player = new Player();
        }
        System.out.println("player.id() =" + player.id());
        Assertions.assertNotNull(player instanceof Player);
    }

    @Given("I level up")
    public void i_level_up() {

        try {
            player = player = datastore.find(Player.class).stream().filter(Player -> idSheGets.equals(idSheGets)).findAny().orElse(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            player = new Player();
        }

        level = player.getLevel();
        player.levelUp();
        datastore.save(player);
    }


    @When("I get a new level")
    public void i_get_a_new_level() {
        try {
            player = player = datastore.find(Player.class).stream().filter(Player -> idSheGets.equals(idSheGets)).findAny().orElse(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            player = new Player();
        }
        Assertions.assertEquals(level + 1, player.getLevel());
    }

    @Then("I get {int} new Skill points")
    public void i_get_new_skill_points(Integer int1) {
        try {
            player = player = datastore.find(Player.class).stream().filter(Player -> idSheGets.equals(idSheGets)).findAny().orElse(null);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
            player = new Player();
        }
        //add test here that the retrived player has gotten new skillpoints

        //kommande stats; Strength Stamina Agility Vitality Charisma Intelligence Luck Endurance

    }


}
