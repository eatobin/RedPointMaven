package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RosterTest {
    private Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster("Blackhawks", 2010);
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Antti Niemi", blackhawks2010.getPlayerName("AntNie"));
        Assert.assertEquals("Bryan Bickell", blackhawks2010.getPlayerName("BryBic"));
        Assert.assertNull(blackhawks2010.getPlayerName("X"));
    }

    @Test
    public void testGetGiveeCode() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertEquals("BriCam", blackhawks2010.getGiveeCode("PatSha", 0));
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
    public void testAddNewYear() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        blackhawks2010.addNewYear();
        Assert.assertEquals("none", blackhawks2010.getGiveeCode("AdaBur", 1));
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
    }

    @Test
    public void saveStringToFile() {
        String saveString = "Line one of, Test, me.";
        Assert.assertTrue(Roster.saveStringToFile("testsavestring.txt",
                        saveString)
        );
        List<String> newStringList = Roster.getStringListFromFile("testsavestring.txt");
        System.out.println();
        System.out.println(newStringList.toString());
        System.out.println();
        Assert.assertEquals(newStringList.get(1), "Test");
        Assert.assertEquals(newStringList.get(2), "me.");
        Assert.assertEquals(3, newStringList.size());
    }
}
