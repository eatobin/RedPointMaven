package RedPointMaven;

import org.junit.Assert;
import org.junit.Test;

public class RosterTest {
    @Test
    public void testRosterSize() {
        Roster myRoster = new Roster();

        Assert.assertEquals(18, myRoster.rosterSize());

        myRoster.roster.put(199, "Eric Tobin");
        Assert.assertEquals(19, myRoster.rosterSize());
    }

    @Test
    public void testReturnPlayerName() {
        Roster myRoster = new Roster();

        myRoster.roster.put(199, "Eric Tobin");
        Assert.assertEquals(19, myRoster.rosterSize());

        Assert.assertEquals("Eric Tobin", myRoster.returnPlayerName(199));
    }
}
