package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HatTest {
    ArrayList<String> pucks;
    Hat hat;

    @Before
    public void setUp() {
        pucks = new ArrayList<String>();
        hat = new Hat(pucks);
        pucks.add("EriTob");
        pucks.add("NanLon");
        pucks.add("JerCoh");
    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(3, hat.pucks.size());
        Assert.assertEquals("JerCoh", hat.pucks.get(2));
        Assert.assertTrue(!hat.drawPuck().equals("none"));

        hat.pucks.clear();
        Assert.assertEquals("none", hat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Assert.assertTrue(hat.removePuck("NanLon"));
        Assert.assertEquals(2, hat.pucks.size());
        Assert.assertFalse(hat.removePuck("NanLon"));
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
