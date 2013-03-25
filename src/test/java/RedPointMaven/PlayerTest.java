package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player myPlayer;

    @Before
    public void setUp() {
        myPlayer = new Player("Eric Tobin", "JerCoh");
    }

    @Test
    public void testPlayer() {
        Assert.assertEquals("Eric Tobin", myPlayer.playerName);
        Assert.assertEquals("JerCoh", myPlayer.pastGivees.get(0));
    }

    @Test
    public void testAddNewGiftee() {
        Assert.assertTrue(myPlayer.addGivee("SarArt"));
        Assert.assertEquals("SarArt", myPlayer.pastGivees.get(1));
    }

    @Test
    public void testReturnGiftee() {
        Assert.assertEquals("JerCoh", myPlayer.returnGivee(0));
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Eric Tobin", myPlayer.getPlayerName());
    }
}
