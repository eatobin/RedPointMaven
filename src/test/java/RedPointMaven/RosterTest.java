package RedPointMaven;

import junit.framework.TestCase;

public class RosterTest extends TestCase {
    public void testRosterSize() {
        Roster myRoster = new Roster();

        assertEquals(18, myRoster.rosterSize());

        myRoster.roster.put(199, "Eric Tobin");
        assertEquals(19, myRoster.rosterSize());
    }

    public void testReturnPlayerName() {
        Roster myRoster = new Roster();

        myRoster.roster.put(199, "Eric Tobin");
        assertEquals(19, myRoster.rosterSize());

        assertEquals("Eric Tobin", myRoster.returnPlayerName(199));
    }
}
