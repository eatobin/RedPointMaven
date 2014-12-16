package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {
    private Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster("blackhawks2010.txt");
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Troy Brouwer", blackhawks2010.getPlayerName("TroBro"));
        Assert.assertEquals("Adam Burish", blackhawks2010.getPlayerName("AdaBur"));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testGetGiveeCode() {
        Assert.assertEquals("DavBol", blackhawks2010.getGiveeCode("TroBro", 0));
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testGetGiverCode() {
        Assert.assertEquals("JonToe", blackhawks2010.getGiverCode("AdaBur", 0));
        Assert.assertEquals("DavBol", blackhawks2010.getGiverCode("PatSha", 0));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testSetGiveeCode() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertEquals("DunKei", blackhawks2010.setGiveeCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testSetGiverCode() {
        Assert.assertEquals("JonToe", blackhawks2010.getGiverCode("AdaBur", 0));
        Assert.assertEquals("JonToe", blackhawks2010.setGiverCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", blackhawks2010.getGiverCode("AdaBur", 0));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testAddNewYear() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        blackhawks2010.addNewYear();
        Assert.assertEquals("none", blackhawks2010.getGiveeCode("AdaBur", 1));
        Assert.assertEquals("none", blackhawks2010.getGiverCode("AdaBur", 1));
    }

    @Test
    public void testGetTeamName() {
        Assert.assertEquals("Blackhawks", blackhawks2010.getTeamName());
    }

    @Test
    public void testGetFirstYear() {
        Assert.assertEquals(2010, blackhawks2010.getFirstYear());
    }

    @Test
    public void testPrintGivingRoster() {
        blackhawks2010.printGivingRoster(0);

        // introduce an error and see if the method chokes on it
        blackhawks2010.setGiveeCode("AdaBur", "anAwfullyBadPlayerCode", 0);
        System.out.println();
        System.out.println("Check out who Adam Burish is giving to!:");
        System.out.println();
        blackhawks2010.printGivingRoster(0);
    }
}
