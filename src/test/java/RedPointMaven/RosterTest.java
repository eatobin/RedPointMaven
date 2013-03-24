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

    @Test
    public void testReturnPlayerName() {
        Assert.assertEquals("Eric Tobin", myRoster.returnPlayerName("EriTob"));
        Assert.assertEquals("Jerri Cohen", myRoster.returnPlayerName("JerCoh"));
    }
}

