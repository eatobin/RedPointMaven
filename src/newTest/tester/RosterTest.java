package tester;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RosterTest {
    Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster();
    }

    @Test
    public void testGetPlayerName() {
        Assert.assertEquals("Antti Niemi", blackhawks2010.getPlayerName("AntNie"));
        Assert.assertEquals("Bryan Bickell", blackhawks2010.getPlayerName("BryBic"));
    }

    @Test
    public void testGetGiveeCode() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertEquals("BriCam", blackhawks2010.getGiveeCode("PatSha", 0));
    }

    @Test
    public void testSetGiveeCode() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        Assert.assertEquals("DunKei", blackhawks2010.setGiveeCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", blackhawks2010.getGiveeCode("AdaBur", 0));
    }

    @Test
    public void testAddNewYear() {
        Assert.assertEquals("DunKei", blackhawks2010.getGiveeCode("AdaBur", 0));
        blackhawks2010.addNewYear();
        Assert.assertEquals("none", blackhawks2010.getGiveeCode("AdaBur", 1));
    }
}
