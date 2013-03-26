package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
    Roster myRoster;

    @Before
    public void setUp() {
        myRoster = new Roster();
        myRoster.addGivee("EriTob", "JerCoh");
        myRoster.addGivee("SarArt", "EriTob");
        myRoster.addGivee("JerCoh", "SarArt");
    }

    @Test
    public void testGiveeNotRecip() {
        Assert.assertTrue(Rules.giveeNotRecip("EriTob", "SarArt", myRoster, 0));
        Assert.assertFalse(Rules.giveeNotRecip("JerCoh", "SarArt", myRoster, 0));
        Assert.assertTrue(Rules.giveeNotRecip("JerCoh", "SarArt", myRoster, 1));
        Assert.assertTrue(Rules.giveeNotRecip("EriTob", "JerCoh", myRoster, 1));
        myRoster.roster.get("JerCoh").pastGivees.set(1, "EriTob");
        Assert.assertFalse(Rules.giveeNotRecip("EriTob", "JerCoh", myRoster, 1));
    }

    @Test
    public void testGiveeNotRepeat() {

    }
}
