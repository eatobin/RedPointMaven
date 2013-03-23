package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player myPlayer;

    @Before
    public void setUp() {
        myPlayer = new Player("Eric", 56);
    }

    @Test
    public void testPlayer() {
        Assert.assertEquals("Eric", myPlayer.playerName);
        Assert.assertEquals(56, (int) myPlayer.pastGivees.get(0));
    }

    @Test
    public void testAddNewGiftee() {
        Assert.assertTrue(myPlayer.addGiftee(57));
        Assert.assertEquals(57, (int) myPlayer.pastGivees.get(1));
    }

    @Test
    public void testReturnGiftee() {
        Assert.assertEquals(56, myPlayer.returnGiftee(0));
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Eric", myPlayer.getPlayerName());
    }
}
