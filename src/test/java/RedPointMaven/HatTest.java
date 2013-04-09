package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HatTest {
    Roster blackhawks2010;
    Hat hat;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster();
        hat = new Hat(blackhawks2010);
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
//
//    @Test
//    public void testRemovePuck() {
//        Assert.assertTrue(hat.removePuck("SarArt"));
//        Assert.assertEquals(2, hat.pucks.size());
//        Assert.assertFalse(hat.removePuck("SarArt"));
//        Assert.assertTrue(hat.removePuck("EriTob"));
//        Assert.assertTrue(hat.removePuck("JerCoh"));
//        Assert.assertTrue(hat.drawPuck().equals("none"));
//    }
//
//    @Test
//    public void testDiscardPuck() {
//        Assert.assertTrue(hat.discardPuck("JerCoh"));
//        Assert.assertEquals(1, hat.discardsSize());
//        Assert.assertEquals(2, hat.pucks.size());
//        Assert.assertTrue(hat.discards.contains("JerCoh"));
//    }
//
//    @Test
//    public void testReturnDiscards() {
//        Assert.assertTrue(hat.discardPuck("EriTob"));
//        Assert.assertEquals(2, hat.pucks.size());
//        Assert.assertEquals(1, hat.discardsSize());
//        Assert.assertFalse(hat.pucks.contains("EriTob"));
//        Assert.assertTrue(hat.discards.contains("EriTob"));
//
//        hat.returnDiscards();
//        Assert.assertEquals(3, hat.pucks.size());
//        Assert.assertEquals(0, hat.discardsSize());
//        Assert.assertTrue(hat.pucks.contains("EriTob"));
//    }
}
