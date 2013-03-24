package RedPointMaven;

import org.junit.Assert;
import org.junit.Test;

public class RosterOldTest {
    @Test
    public void testRosterSize() {
        RosterOld myRosterOld = new RosterOld();

        Assert.assertEquals(18, myRosterOld.rosterSize());

        myRosterOld.roster.put(199, "Eric Tobin");
        Assert.assertEquals(19, myRosterOld.rosterSize());
    }

    @Test
    public void testReturnPlayerName() {
        RosterOld myRosterOld = new RosterOld();

        myRosterOld.roster.put(199, "Eric Tobin");
        Assert.assertEquals(19, myRosterOld.rosterSize());

        Assert.assertEquals("Eric Tobin", myRosterOld.returnPlayerName(199));
    }
}
