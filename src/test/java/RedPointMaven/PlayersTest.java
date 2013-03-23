package RedPointMaven;

import org.junit.Before;
import org.junit.Test;

public class PlayersTest {
    Players myPlayers;

    @Before
    public void setUp() {
        Players myPlayers = new Players();
    }

    @Test
    public void testaddPlayer() {
        myPlayers.addPlayer(new Player("Ericky", 22));
    }
}
