package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
    public void testGiveeNotSelf() {
        Assert.assertFalse(Rules.giveeNotSelf("EriTob", "EriTob"));
        Assert.assertTrue(Rules.giveeNotSelf("EriTob", "JerCoh"));
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
        myRoster.roster.put("ScoTob", new Player("Scott Tobin", "JerCoh"));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "JerCoh", myRoster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "JerCoh", myRoster, 2));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "ScoTob", myRoster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 2));
        System.out.println(myRoster.roster.get("EriTob").pastGivees.toString());
        myRoster.roster.get("EriTob").pastGivees.set(0, "JerCoh");
        System.out.println(myRoster.roster.get("EriTob").pastGivees.toString());
        ArrayList<String> newList = new ArrayList<String>();
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        myRoster.roster.get("EriTob").pastGivees.addAll(newList);
        System.out.println(myRoster.roster.get("EriTob").pastGivees.toString());
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 6));
        myRoster.roster.get("EriTob").pastGivees.set(1, "SarArt");
        System.out.println(myRoster.roster.get("EriTob").pastGivees.toString());
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 6));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 5));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", myRoster, 1));
    }
}
