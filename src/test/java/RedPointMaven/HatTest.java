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
        myArr.add("Italian Riviera");
        myArr.add("Jersey Shore");
        myArr.add("Puerto Rico");
        myArr.add("Los Cabos Corridor");
        myArr.add("Lubmin");
        myArr.add("Coney Island");
        myArr.add("Karlovy Vary");
        myArr.add("Bourbon-l'Archambault");
        myArr.add("Walt Disney World Resort");
        myArr.add("Barbados");
        myHat = new Hat(myArr);
    }

    @Test
    public void testDrawPuck() {
        Assert.assertEquals(10, myHat.pucks.size());
        Assert.assertEquals("Puerto Rico", myHat.pucks.get(2));
        Assert.assertTrue(myHat.drawPuck() != "None");
        //Assert.assertTrue("Fails - Greater than", myHat.drawPuck() <= 102);

        myHat.pucks.clear();
        Assert.assertEquals("none", myHat.drawPuck());
    }

   /* @Test
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
    }*/
}
