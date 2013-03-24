package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HatTest {
    Hat myHat;

    @Before
    public void setUp() {
        ArrayList<String> myArr = new ArrayList<String>();
        myArr.add("EriTob");
        myArr.add("NanLon");
        myArr.add("JerCoh");
        myHat = new Hat(myArr);
    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(3, myHat.pucks.size());
        Assert.assertEquals("JerCoh", myHat.pucks.get(2));
        Assert.assertTrue(!myHat.drawPuck().equals("none"));

        myHat.pucks.clear();
        Assert.assertEquals("none", myHat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Assert.assertTrue(myHat.removePuck("NanLon"));
        Assert.assertEquals(2, myHat.pucks.size());
        Assert.assertFalse(myHat.removePuck("NanLon"));
        Assert.assertTrue(myHat.removePuck("EriTob"));
        Assert.assertTrue(myHat.removePuck("JerCoh"));
        Assert.assertTrue(myHat.drawPuck().equals("none"));
    }

    @Test
    public void testDiscardPuck() {
        Assert.assertTrue(myHat.discardPuck("JerCoh"));
        Assert.assertEquals(1, myHat.discardsSize());
        Assert.assertEquals(2, myHat.pucks.size());
        Assert.assertTrue(myHat.discards.contains("JerCoh"));
    }

    @Test
    public void testReturnDiscards() {
        Assert.assertTrue(myHat.discardPuck("EriTob"));
        Assert.assertEquals(2, myHat.pucks.size());
        Assert.assertEquals(1, myHat.discardsSize());
        Assert.assertFalse(myHat.pucks.contains("EriTob"));
        Assert.assertTrue(myHat.discards.contains("EriTob"));

        myHat.returnDiscards();
        Assert.assertEquals(3, myHat.pucks.size());
        Assert.assertEquals(0, myHat.discardsSize());
        Assert.assertTrue(myHat.pucks.contains("EriTob"));
    }
}
