package RedPointMaven;

import junit.framework.TestCase;

public class HatTest extends TestCase {
    public void testDrawPuck() {
        Hat myHat = new Hat(3);

        assertEquals(3, myHat.pucks.size());
        assertEquals(102, (int) myHat.pucks.get(2));
        assertTrue("Fails - Less than", myHat.drawPuck() >= 100);
        assertTrue("Fails - Greater than", myHat.drawPuck() <= 102);

        myHat.pucks.clear();
        assertEquals(0, myHat.drawPuck());
    }

    public void testRemovePuck() {
        Hat myHat = new Hat(3);

        assertTrue(myHat.removePuck(100));
        assertEquals(2, myHat.pucks.size());
    }

    public void testDiscardsSize() {
        Hat myHat = new Hat(3);

        assertTrue(myHat.discardPuck(100));
        assertEquals(1, myHat.discardsSize());
    }

    public void testDiscardPuck() {
        Hat myHat = new Hat(3);

        assertTrue(myHat.discardPuck(100));
        assertFalse(myHat.discardPuck(109));
        assertEquals(2, myHat.pucks.size());
    }

    public void testReturnDiscards() {
        Hat myHat = new Hat(3);

        assertTrue(myHat.discardPuck(100));
        assertEquals(2, myHat.pucks.size());
        assertEquals(1, myHat.discardsSize());
        assertFalse(myHat.pucks.contains(new Integer(100)));
        assertTrue(myHat.discards.contains(new Integer(100)));

        myHat.returnDiscards();
        assertEquals(3, myHat.pucks.size());
        assertEquals(0, myHat.discardsSize());
        assertTrue(myHat.pucks.contains(new Integer(100)));
    }
}
