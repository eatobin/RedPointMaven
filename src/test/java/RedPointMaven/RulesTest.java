package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RulesTest {
    Roster roster;

    @Before
    public void setUp() {
        roster = new Roster();
        roster.roster.clear();
        roster.roster.put("EriTob", new Player("Eric Tobin", "SarArt"));
        roster.roster.put("SarArt", new Player("Sarah Artzi", "JerCoh"));
        roster.roster.put("JerCoh", new Player("Jerri Cohen", "EriTob"));
        roster.setGivee("EriTob", "JerCoh", 1);
        roster.setGivee("SarArt", "EriTob", 1);
        roster.setGivee("JerCoh", "SarArt", 1);
    }

    @Test
    public void testGiveeNotSelf() {
        Assert.assertFalse(Rules.giveeNotSelf("EriTob", "EriTob"));
        Assert.assertTrue(Rules.giveeNotSelf("EriTob", "JerCoh"));
    }

    @Test
    public void testGiveeNotRecip() {
        Assert.assertTrue(Rules.giveeNotRecip("EriTob", "SarArt", roster, 0));
        Assert.assertFalse(Rules.giveeNotRecip("JerCoh", "SarArt", roster, 0));
        Assert.assertTrue(Rules.giveeNotRecip("JerCoh", "SarArt", roster, 1));
        Assert.assertTrue(Rules.giveeNotRecip("EriTob", "JerCoh", roster, 1));
        roster.roster.get("JerCoh").pastGivees.set(1, "EriTob");
        Assert.assertFalse(Rules.giveeNotRecip("EriTob", "JerCoh", roster, 1));
    }

    @Test
    public void testGiveeNotRepeat() {
        roster.roster.put("ScoTob", new Player("Scott Tobin", "JerCoh"));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "JerCoh", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "JerCoh", roster, 2));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "ScoTob", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 2));
        System.out.println(roster.roster.get("EriTob").pastGivees.toString());
        roster.roster.get("EriTob").pastGivees.set(0, "JerCoh");
        System.out.println(roster.roster.get("EriTob").pastGivees.toString());
        ArrayList<String> newList = new ArrayList<String>();
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        roster.roster.get("EriTob").pastGivees.addAll(newList);
        System.out.println(roster.roster.get("EriTob").pastGivees.toString());
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 6));
        roster.roster.get("EriTob").pastGivees.set(1, "SarArt");
        System.out.println(roster.roster.get("EriTob").pastGivees.toString());
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 6));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 5));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 1));
    }
}
