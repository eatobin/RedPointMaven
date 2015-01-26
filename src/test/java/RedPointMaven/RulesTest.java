package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
    private Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster("blackhawks2010.txt");
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
        int GIVEE = 0;
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "AdaBur", 1, GIVEE);
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 1));
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "AndLad", 2, GIVEE);
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "AntNie", 3, GIVEE);
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "BreSea", 4, GIVEE);
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "BryBic", 5, GIVEE);
        blackhawks2010.addNewYear();
        blackhawks2010.setRoledPlayerCode("PatSha", "BriCam", 6, GIVEE);
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 6));
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 6));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "AdaBur", blackhawks2010, 5));
        Assert.assertTrue(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 5));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BriCam", blackhawks2010, 4));
        Assert.assertFalse(Rules.giveeNotRepeat("PatSha", "BryBic", blackhawks2010, 6));
    }
}
