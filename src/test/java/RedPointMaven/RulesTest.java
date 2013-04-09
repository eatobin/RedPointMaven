package RedPointMaven;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RulesTest {
    Roster roster;

//    @Before
//    public void setUp() {
//        roster = new Roster();
//        roster.roster_list.clear();
//        roster.roster_list.put("EriTob", roster.new Player("Eric Tobin", "SarArt")); //TODO Use constructor values
//        roster.roster_list.put("SarArt", roster.new Player("Sarah Artzi", "JerCoh")); //TODO Use constructor values
//        roster.roster_list.put("JerCoh", roster.new Player("Jerri Cohen", "EriTob")); //TODO Use constructor values
//        roster.addNewYear();
//        roster.setGivee("EriTob", "JerCoh", 1);
//        roster.setGivee("SarArt", "EriTob", 1);
//        roster.setGivee("JerCoh", "SarArt", 1);
//    }

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
        //roster.roster_list.get("JerCoh").pastGivees.set(1, "EriTob"); //TODO Use constructor values
        Assert.assertFalse(Rules.giveeNotRecip("EriTob", "JerCoh", roster, 1));
    }

    @Test
    public void testGiveeNotRepeat() {
        //roster.roster_list.put("ScoTob", roster.new Player("Scott Tobin", "JerCoh"));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "JerCoh", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "JerCoh", roster, 2));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "ScoTob", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 1));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 2));
        //System.out.println(roster.roster_list.get("EriTob").pastGivees.toString()); //TODO Use constructor values
        //roster.roster_list.get("EriTob").pastGivees.set(0, "JerCoh"); //TODO Use constructor values
       // System.out.println(roster.roster_list.get("EriTob").pastGivees.toString()); //TODO Use constructor values
        ArrayList<String> newList = new ArrayList<String>();
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        newList.add("JerCoh");
        //roster.roster_list.get("EriTob").pastGivees.addAll(newList); //TODO Use constructor values
        //System.out.println(roster.roster_list.get("EriTob").pastGivees.toString()); //TODO Use constructor values
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 6));
        //roster.roster_list.get("EriTob").pastGivees.set(1, "SarArt"); //TODO Use constructor values
       // System.out.println(roster.roster_list.get("EriTob").pastGivees.toString()); //TODO Use constructor values
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 6));
        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 5));
        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", roster, 1));
    }
}
