package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayersTest {
    Player myPlayer;
    Players myPlayers;

    @Before
    public void setUp() {
        myPlayer = new Player("Eric", 56);
        myPlayers = new Players();
    }

    @Test
    public void testPlayers() {
        Assert.assertEquals("Eric", myPlayer.playerName);
        Assert.assertEquals(56, myPlayer.returnGiftee(0));
        Assert.assertTrue(myPlayers.players.isEmpty());
    }

    @Test
    public void testAddPlayer(){
        myPlayers.players.add(myPlayer);
        Assert.assertEquals(0, myPlayers.players.indexOf(myPlayer));
        Assert.assertEquals(56, myPlayers.players.get(0).returnGiftee(0));
    }
}
