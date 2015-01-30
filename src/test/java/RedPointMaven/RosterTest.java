package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {
    private Roster roster;

    @Before
    public void setUp() {
        roster = new Roster("blackhawks2010.txt");
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Troy Brouwer", roster.getPlayerName("TroBro"));
        Assert.assertEquals("Adam Burish", roster.getPlayerName("AdaBur"));
        Assert.assertNull(roster.getPlayerName("X"));
    }

    @Test
    public void testGetGiveeCode() {
        Assert.assertEquals("DavBol", roster.getRoledPlayerCode("TroBro", 0, "GIVEE"));
        Assert.assertEquals("DunKei", roster.getRoledPlayerCode("AdaBur", 0, "GIVEE"));
        Assert.assertNull(roster.getPlayerName("X"));
    }

    @Test
    public void testGetGiverCode() {
        Assert.assertEquals("JonToe", roster.getRoledPlayerCode("AdaBur", 0, "GIVER"));
        Assert.assertEquals("DavBol", roster.getRoledPlayerCode("PatSha", 0, "GIVER"));
        Assert.assertNull(roster.getPlayerName("X"));
    }

    @Test
    public void testSetGiveeCode() {
        Assert.assertEquals("DunKei", roster.getRoledPlayerCode("AdaBur", 0, "GIVEE"));
        Assert.assertEquals("MarHos", roster.setRoledPlayerCode("AdaBur", "MarHos", 0, "GIVEE"));
        Assert.assertEquals("MarHos", roster.getRoledPlayerCode("AdaBur", 0, "GIVEE"));
        Assert.assertNull(roster.getPlayerName("X"));
    }

    @Test
    public void testSetGiverCode() {
        Assert.assertEquals("JonToe", roster.getRoledPlayerCode("AdaBur", 0, "GIVER"));
        Assert.assertEquals("MarHos", roster.setRoledPlayerCode("AdaBur", "MarHos", 0, "GIVER"));
        Assert.assertEquals("MarHos", roster.getRoledPlayerCode("AdaBur", 0, "GIVER"));
        Assert.assertNull(roster.getPlayerName("X"));
    }

    @Test
    public void testAddNewYear() {
        Assert.assertEquals("DunKei", roster.getRoledPlayerCode("AdaBur", 0, "GIVEE"));
        roster.addNewYear();
        Assert.assertEquals("none", roster.getRoledPlayerCode("AdaBur", 1, "GIVEE"));
        Assert.assertEquals("none", roster.getRoledPlayerCode("AdaBur", 1, "GIVER"));
    }

    @Test
    public void testGetTeamName() {
        Assert.assertEquals("Blackhawks", roster.getTeamName());
    }

    @Test
    public void testGetFirstYear() {
        Assert.assertEquals(2010, roster.getFirstYear());
    }

    @Test
    public void testPrintGivingRoster() {
        roster.printGivingRoster(0);

        // introduce an error and see if the method chokes on it
        roster.setRoledPlayerCode("AdaBur", "anAwfullyBadPlayerCode", 0, "GIVEE");
        System.out.println();
        System.out.println("Check out who Adam Burish is giving to!:");
        System.out.println();
        roster.printGivingRoster(0);

        // go to a short roster to see logic errors
        System.out.println();
        roster = new Roster("empty2014.txt");
        roster.printGivingRoster(0);
    }
}
