package RedPointMaven;

import junit.framework.TestCase;

public class PuckTest extends TestCase {
    public void testPuck() {
        Puck myPuck = new Puck("Eric", 56);
        assertEquals("Eric", myPuck.playerName);
    }
}
