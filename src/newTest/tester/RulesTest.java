package tester;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
    Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster("Blackhawks", 2010);
    }

    @Test
    public void testGiveeNotSelf() {
        Assert.assertFalse(Rules.giveeNotSelf("PatSha", "PatSha"));
        Assert.assertTrue(Rules.giveeNotSelf("PatSha", "AdaBur"));
    }

    @Test
    public void testGiveeNotRecip() {
        Assert.assertTrue(Rules.giveeNotRecip("PatSha", "AdaBur", blackhawks2010, 0));
        Assert.assertFalse(Rules.giveeNotRecip("BriCam", "PatSha", blackhawks2010, 0));
    }

    @Test
    public void testGiveeNotRepeat() {
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "AdaBur", 1);
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 1));
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "AndLad", 2);
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "AntNie", 3);
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "BreSea", 4);
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "BryBic", 5);
        blackhawks2010.addNewYear();
        blackhawks2010.setGiveeCode("PatSha", "BriCam", 6);
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 6));
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 6));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 5));
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 5));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 4));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BryBic", blackhawks2010, 6));
    }
}
