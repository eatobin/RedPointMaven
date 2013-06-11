package RedPointMaven;

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
    public void testReturnGivee() {
        Assert.assertEquals("DunKei", blackhawks2010.returnGiveeCode("AdaBur", 0));
        Assert.assertEquals("BriCam", blackhawks2010.returnGiveeCode("PatSha", 0));
    }

    @Test
    public void testSetGivee() {
        Assert.assertEquals("DunKei", blackhawks2010.returnGiveeCode("AdaBur", 0));
        Assert.assertEquals("DunKei", blackhawks2010.setGiveeCode("AdaBur", "MarHos", 0));
        Assert.assertEquals("MarHos", blackhawks2010.returnGiveeCode("AdaBur", 0));
    }

    @Test
    public void testAddNewYear() {
        blackhawks2010.addNewYear();
        Assert.assertEquals("DunKei", blackhawks2010.returnGiveeCode("AdaBur", 0));
        Assert.assertEquals("none", blackhawks2010.returnGiveeCode("AdaBur", 1));
    }

    @Test
    public void testPrintGivingRoster() {
        blackhawks2010.printAndAsk(0, false);
    }
}
