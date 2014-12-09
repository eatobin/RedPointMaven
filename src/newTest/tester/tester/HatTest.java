package tester;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HatTest {
    Roster blackhawks2010;
    Hat hat;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster("Blackhawks", 2010);
        hat = new Hat(blackhawks2010.getRosterListCodes());
    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(18, hat.pucks.size());
        //alphabetical print of Array?
        System.out.println(hat.pucks.toString());
        Assert.assertEquals("AndLad", hat.pucks.get(1));
        Assert.assertTrue(!hat.drawPuck().equals("none"));

        hat.pucks.clear();
        Assert.assertEquals("none", hat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Assert.assertTrue(hat.removePuck("AndLad"));
        Assert.assertEquals(17, hat.pucks.size());
        hat.pucks.clear();
        Assert.assertTrue(hat.drawPuck().equals("none"));
    }

    @Test
    public void testDiscardPuck() {
        Assert.assertTrue(hat.discardPuck("AndLad"));
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertEquals(17, hat.pucks.size());
        Assert.assertTrue(hat.discards.contains("AndLad"));
    }

    @Test
    public void testReturnDiscards() {
        Assert.assertTrue(hat.discardPuck("AndLad"));
        Assert.assertEquals(17, hat.pucks.size());
        Assert.assertEquals(1, hat.discardsSize());
        Assert.assertFalse(hat.pucks.contains("AndLad"));
        Assert.assertTrue(hat.discards.contains("AndLad"));

        hat.returnDiscards();
        Assert.assertEquals(18, hat.pucks.size());
        Assert.assertEquals(0, hat.discardsSize());
        Assert.assertTrue(hat.pucks.contains("AndLad"));
    }
}
