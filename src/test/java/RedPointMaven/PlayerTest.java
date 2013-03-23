package RedPointMaven;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    public void testPlayer() {
        Player myPlayer = new Player("Eric", 56);
        assertEquals("Eric", myPlayer.playerName);
        assertEquals(56, (int)myPlayer.pastGivees.get(0));
    }
}
