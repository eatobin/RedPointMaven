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
    public void testGetGiveeCode() {
        Assert.assertEquals("DavBol", roster.getGiveeCode("TroBro", 0));
        Assert.assertEquals("DunKei", roster.getGiveeCode("AdaBur", 0));
    }

    @Test
    public void testGetGiverCode() {
        Assert.assertEquals("JonToe", roster.getGiverCode("AdaBur", 0));
        Assert.assertEquals("DavBol", roster.getGiverCode("PatSha", 0));
    }

    @Test
    public void testSetGiveeCode() {
        Assert.assertEquals("DunKei", roster.getGiveeCode("AdaBur", 0));
        Assert.assertEquals("MarHos", roster.setGiveeCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", roster.getGiveeCode("AdaBur", 0));
        Assert.assertEquals(null, roster.setGiveeCode("AdaBur", "X", 0));
    }

    @Test
    public void testSetGiverCode() {
        Assert.assertEquals("JonToe", roster.getGiverCode("AdaBur", 0));
        Assert.assertEquals("MarHos", roster.setGiverCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", roster.getGiverCode("AdaBur", 0));
        Assert.assertEquals(null, roster.setGiverCode("AdaBur", "X", 0));
    }

    @Test
    public void testAddNewYear() {
        Assert.assertEquals("DunKei", roster.getGiveeCode("AdaBur", 0));
        roster.addNewYear();
        Assert.assertEquals("none", roster.getGiveeCode("AdaBur", 1));
        Assert.assertEquals("none", roster.getGiveeCode("AdaBur", 1));
    }

    @Test
    public void testPrintGivingRoster() {
        roster.printGivingRoster(0);

        // introduce an error and see if the method chokes on it
        roster.setGiveeCode("AdaBur", "anAwfullyBadPlayerCode", 0);
        System.out.println();
        System.out.println("After \'roster.setGiveeCode(\"AdaBur\", \"anAwfullyBadPlayerCode\", 0);\'\nAdam Burish givee is unchanged:");
        System.out.println();
        roster.printGivingRoster(0);

        // go to a short roster to see logic errors
        System.out.println();
        roster = new Roster("empty2014.txt");
        roster.printGivingRoster(0);
    }
}
