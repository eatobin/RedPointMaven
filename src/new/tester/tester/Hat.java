package tester;

/**
 * Class acts as a virtual hat of pucks. Hat is initialized with roster_list of players.
 * Pucks can be drawn at random, removed and replaced after discard.
 */

import java.util.ArrayList;
import java.util.Random;

public class Hat {
    ArrayList<String> pucks;
    ArrayList<String> discards;

    /**
     * Constructor for objects of class Hat given a roster_list.
     */
    public Hat(Roster roster) {
        //initialize instance variables
        pucks = new ArrayList<String>(roster.getRosterList().keySet());
        discards = new ArrayList<String>();
    }

    /**
     * Draws a puck at random (by ArrayList index number). Returns the playerCode
     * randomly chosen or "none" if ArrayList empty.
     */
    public String drawPuck() {
        // construct a random number between 0 and (pucks.size() - 1)
        if (pucks.size() > 0) {
            Random generator = new Random();
            int r = generator.nextInt(pucks.size());

            // return the contents (playerCode) of selected index
            return pucks.get(r);
        }
        // if hat empty
        else {
            return "none";
        }
    }

    /**
     * Removes a puck by given playerCode. Returns true if successful.
     */
    public boolean removePuck(String playerCode) {
        return pucks.remove(playerCode);
    }

    /**
     * Returns the number of pucks in discards
     */
    public int discardsSize() {
        return discards.size();
    }

    /**
     * If puck successfully removed, place the puck (playerCode) in the discard list. Return
     * true if both remove and discard succeed.
     */
    public boolean discardPuck(String playerCode) {
        return pucks.remove(playerCode) && discards.add(playerCode);
    }

    /**
     * Return the discarded pucks to the hat for other player use. Return true if
     * there are discards and they are returned.
     */
    public boolean returnDiscards() {
        boolean worked = false;

        if (discardsSize() > 0) {
            worked = pucks.addAll(discards);
            discards.clear();
        }

        return worked;
    }
}
