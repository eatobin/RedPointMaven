package RedPointMaven;

/**
 * A class to deal with roster mechanics.
 */

import java.util.*;

public class Roster {
    // instance variables
    Map<Integer, String> roster = new HashMap<Integer, String>();

    /**
     * Constructor for objects of class Roster.
     */
    public Roster() {
        /*
        initialize instance variables
        build the roster with Map index for each
        */
        roster.put(100, "Adam Burish");
        roster.put(101, "Andrew Ladd");
        roster.put(102, "Antti Niemi");
        roster.put(103, "Brent Seabrook");
        roster.put(104, "Bryan Bickell");
        roster.put(105, "Brian Campbell");
        roster.put(106, "Cristobal Huet");
        roster.put(107, "Dave Bolland");
        roster.put(108, "Duncan Keith");
        roster.put(109, "Joel Quenneville");
        roster.put(110, "Jonathan Toews");
        roster.put(111, "Kris Versteeg");
        roster.put(112, "Marian Hossa");
        roster.put(113, "Niklas Hjalmarsson");
        roster.put(114, "Patrick Kane");
        roster.put(115, "Patrick Sharp");
        roster.put(116, "Tomas Kopecky");
        roster.put(117, "Troy Brouwer");
    }

    /**
     * How large is the roster? Used to set parameters elsewhere - like initial
     * Hat size.
     */
    public int rosterSize() {
        return roster.size();
    }

    /**
     * Given a a player's key value, Return their name.
     */
    public String returnPlayerName(int playerNum) {
        /*
        uses key:value pair functionality of keySet
        returns a msg if no match (playerNum = 0)
        where last giver/givee in Hats fail a test.
        */
        Set<Integer> myKeySet = roster.keySet();
        String correctName = "...nobody!! (last giver/givee pairing and a test failed - a puzzle logic error)";

        for (Integer aKey : myKeySet) {
            String playerName = roster.get(aKey);

            if (playerNum == aKey) {
                correctName = playerName;
            }
        }

        return correctName;
    }

    /**
     * giftList = this year's gift listing, where i = giver and giftList[i] =
     * givee.
     */
    public void printPairings(int[] giftList) {
        for (int i = 0; i < giftList.length; i++) {
            System.out.println(returnPlayerName(i + 100) + " is buying for "
                    + returnPlayerName(giftList[i]));
        }
    }
}
