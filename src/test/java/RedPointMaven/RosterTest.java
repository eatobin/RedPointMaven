package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {
    Roster myRoster;

    @Before
    public void setUp() {
        myRoster = new Roster();
    }

    @Test
    public void testRosterSize() {
        Assert.assertEquals(3, myRoster.rosterSize());

        myRoster.roster.put("ScoTob", new Player("Scott Tobin", "JerCoh"));
        Assert.assertEquals(4, myRoster.rosterSize());
    }

    /*@Test
    public void testReturnPlayerName() {
        RosterOld myRosterOld = new RosterOld();

        myRosterOld.roster.put(199, "Eric Tobin");
        Assert.assertEquals(19, myRosterOld.rosterSize());

        Assert.assertEquals("Eric Tobin", myRosterOld.returnPlayerName(199));*/
}

