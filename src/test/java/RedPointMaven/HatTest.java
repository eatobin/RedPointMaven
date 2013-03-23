package RedPointMaven;

import org.junit.Assert;
import org.junit.Test;

public class HatTest {
    @Test
    public void testDrawPuck() {
        Hat myHat = new Hat(3);

        Assert.assertEquals(3, myHat.pucks.size());
        Assert.assertEquals(102, (int) myHat.pucks.get(2));
        Assert.assertTrue("Fails - Less than", myHat.drawPuck() >= 100);
        Assert.assertTrue("Fails - Greater than", myHat.drawPuck() <= 102);

        myHat.pucks.clear();
        Assert.assertEquals(0, myHat.drawPuck());
    }

    @Test
    public void testRemovePuck() {
        Hat myHat = new Hat(3);

        Assert.assertTrue(myHat.removePuck(100));
        Assert.assertEquals(2, myHat.pucks.size());
    }

    @Test
    public void testDiscardsSize() {
        Hat myHat = new Hat(3);

        Assert.assertTrue(myHat.discardPuck(100));
        Assert.assertEquals(1, myHat.discardsSize());
    }

    @Test
    public void testDiscardPuck() {
        Hat myHat = new Hat(3);

        Assert.assertTrue(myHat.discardPuck(100));
        Assert.assertFalse(myHat.discardPuck(109));
        Assert.assertEquals(2, myHat.pucks.size());
    }

    @Test
    public void testReturnDiscards() {
        Hat myHat = new Hat(3);

        Assert.assertTrue(myHat.discardPuck(100));
        Assert.assertEquals(2, myHat.pucks.size());
        Assert.assertEquals(1, myHat.discardsSize());
        Assert.assertFalse(myHat.pucks.contains(new Integer(100)));
        Assert.assertTrue(myHat.discards.contains(new Integer(100)));

        myHat.returnDiscards();
        Assert.assertEquals(3, myHat.pucks.size());
        Assert.assertEquals(0, myHat.discardsSize());
        Assert.assertTrue(myHat.pucks.contains(new Integer(100)));
    }
}
