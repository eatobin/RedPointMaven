package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {
    Roster roster;

    @Before
    public void setUp() {
        roster = new Roster();
        roster.roster.clear();
        roster.roster.put("EriTob", new Player("Eric Tobin", "SarArt"));
        roster.roster.put("SarArt", new Player("Sarah Artzi", "JerCoh"));
        roster.roster.put("JerCoh", new Player("Jerri Cohen", "EriTob"));
    }

    @Test
    public void testReturnPlayerName() {
        Assert.assertEquals("Eric Tobin", roster.returnPlayerName("EriTob"));
        Assert.assertEquals("Jerri Cohen", roster.returnPlayerName("JerCoh"));
    }

    @Test
    public void testReturnGivee() {
        Assert.assertEquals("SarArt", roster.returnGivee("EriTob", 0));
        Assert.assertEquals("EriTob", roster.returnGivee("JerCoh", 0));
    }

    @Test
    public void testSetGivee() {
        Assert.assertEquals("SarArt", roster.returnGivee("EriTob", 0));
        Assert.assertEquals("SarArt", roster.setGivee("EriTob", "JerCoh", 0));
        Assert.assertEquals("JerCoh", roster.returnGivee("EriTob", 0));
    }

    @Test
    public void testAddNewYear() {
        roster.addNewYear();
        Assert.assertEquals("JerCoh", roster.returnGivee("SarArt", 0));
        Assert.assertEquals("none", roster.returnGivee("SarArt", 1));
    }

    @Test
    public void testPrintGivingRoster() {
        roster.printGivingRoster(0);
        roster = new Roster();
        System.out.println();
        roster.printGivingRoster(0);
    }
}

