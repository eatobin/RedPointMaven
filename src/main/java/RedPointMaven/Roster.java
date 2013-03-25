package RedPointMaven;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Roster {
    Map<String, Player> roster;

    public Roster() {
        roster = new HashMap<String, Player>();
        roster.put("EriTob", new Player("Eric Tobin", "SarArt"));
        roster.put("SarArt", new Player("Sarah Artzi", "JerCoh"));
        roster.put("JerCoh", new Player("Jerri Cohen", "EriTob"));
    }

    /**
     * How large is the roster? Used to set parameters elsewhere.
     */
    public int rosterSize() {
        return roster.size();
    }

    public String returnPlayerName(String playerCode) {
        return roster.get(playerCode).getPlayerName();
    }

    public boolean addGivee(String playerCode, String givee) {
        return roster.get(playerCode).addGivee(givee);
    }

    public String returnGivee(String playerCode, int giftYear) {
        return roster.get(playerCode).returnGivee(giftYear);
    }

    public void printGivingRoster(int giftYear) {
        /*
        uses key:value pair functionality of keySet
        returns a msg if no match (playerNum = 0)
        where last giver/givee in Hats fail a test.
        */
        Set<String> myKeySet = roster.keySet();
        //String correctName = "...nobody!! (last giver/givee pairing and a test failed - a puzzle logic error)";

        for (String aKey : myKeySet) {
            String playerName = roster.get(aKey).getPlayerName();
            String giveeCode = roster.get(aKey).returnGivee(giftYear);
            String giveeName = roster.get(giveeCode).getPlayerName();
            System.out.println(playerName + " is buying for " + giveeName);
        }
    }
}
