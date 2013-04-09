package RedPointMaven;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
    Roster blackhawks2010;

    @Before
    public void setUp() {
        blackhawks2010 = new Roster();
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
//        //blackhawks2010.roster_list.put("ScoTob", blackhawks2010.new Player("Scott Tobin", "JerCoh"));
//        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "JerCoh", blackhawks2010, 1));
//        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "JerCoh", blackhawks2010, 2));
//        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "ScoTob", blackhawks2010, 1));
//        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 1));
//        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 2));
//        //System.out.println(blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.toString()); //TODO Use constructor values
//        //blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.set(0, "JerCoh"); //TODO Use constructor values
//       // System.out.println(blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.toString()); //TODO Use constructor values
//        ArrayList<String> newList = new ArrayList<String>();
//        newList.add("JerCoh");
//        newList.add("JerCoh");
//        newList.add("JerCoh");
//        newList.add("JerCoh");
//        //blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.addAll(newList); //TODO Use constructor values
//        //System.out.println(blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.toString()); //TODO Use constructor values
//        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 6));
//        //blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.set(1, "SarArt"); //TODO Use constructor values
//       // System.out.println(blackhawks2010.roster_list.get("EriTob").pastGiveesCodes.toString()); //TODO Use constructor values
//        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 6));
//        Assert.assertFalse(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 5));
//        Assert.assertTrue(Rules.giveeNotRepeat("EriTob", "SarArt", blackhawks2010, 1));
    }
}
