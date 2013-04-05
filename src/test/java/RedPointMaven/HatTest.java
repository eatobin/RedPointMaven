package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HatTest {
    Roster roster;
    Hat hat;

    @Before
    public void setUp() {
        roster = new Roster();
        roster.roster_list.clear();
        roster.roster_list.put("EriTob", new Player("Eric Tobin", "SarArt"));
        roster.roster_list.put("SarArt", new Player("Sarah Artzi", "JerCoh"));
        roster.roster_list.put("JerCoh", new Player("Jerri Cohen", "EriTob"));
        hat = new Hat(roster);

    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(3, hat.pucks.size());
        System.out.println(hat.pucks.toString());
        Assert.assertEquals("JerCoh", hat.pucks.get(1));
        Assert.assertTrue(!hat.drawPuck().equals("none"));

        hat.pucks.clear();
        Assert.assertEquals("none", hat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Assert.assertTrue(hat.removePuck("SarArt"));
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertFalse(hat.removePuck("SarArt"));
        Assert.assertTrue(hat.removePuck("EriTob"));
        Assert.assertTrue(hat.removePuck("JerCoh"));
        Assert.assertTrue(hat.drawPuck().equals("none"));
    }

    @Test
    public void testDiscardPuck() {
        Assert.assertTrue(hat.discardPuck("JerCoh"));
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertTrue(hat.discards.contains("JerCoh"));
    }

    @Test
    public void testReturnDiscards() {
        Assert.assertTrue(hat.discardPuck("EriTob"));
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertFalse(hat.pucks.contains("EriTob"));
        Assert.assertTrue(hat.discards.contains("EriTob"));

        hat.returnDiscards();
        Assert.assertEquals(3, hat.pucks.size());
        Assert.assertEquals(0, hat.discardsSize());
        Assert.assertTrue(hat.pucks.contains("EriTob"));
    }
}
