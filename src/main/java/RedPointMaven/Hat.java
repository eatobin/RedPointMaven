package RedPointMaven;

/**
 * Class acts as a virtual hat of pucks. Hat is initialized with number of players.
 * Pucks can be drawn at random, removed and replaced after discard.
 */

import java.util.*;

public class Hat {
    // instance variables
    ArrayList<Integer> pucks;
    ArrayList<Integer> discards;

    /**
     * Constructor for objects of class Hat given a roster size
     */
    public Hat(int rosterSize) {
        /*
        initialize instance variables
        auto boxing!
        */
        pucks = new ArrayList<Integer>();
        for (int i = 100; i < (rosterSize + 100); i++) {
            pucks.add(i);
        }
        discards = new ArrayList<Integer>();
    }

    /**
     * Draws a puck at random (by ArrayList index number) Returns the playerNumber
     * randomly chosen or 0 if ArrayList empty
     */
    public int drawPuck() {
        // construct a random number between 0 and (pucks.size() - 1)
        if (pucks.size() > 0) {
            Random generator = new Random();
            int r = generator.nextInt(pucks.size());

            // return the contents (playerNumber) of selected index
            return pucks.get(r);
        }
        // if hat empty
        else {
            return 0;
        }
    }

    /**
     * Removes a puck by given playerNumber Returns true if successful
     */
    public boolean removePuck(int x) {
        return pucks.remove(new Integer(x));
    }

    /**
     * Returns the number of pucks in discards
     */
    public int discardsSize() {
        return discards.size();
    }

    /**
     * If puck successfully removed, place the puck (x) in the discard list Return
     * true if both remove and discard succeed
     */
    public boolean discardPuck(int x) {
        return pucks.remove(new Integer(x)) && discards.add(x);
    }

    /**
     * Return the discarded pucks to the hat for other player use Return true if
     * there are discards and they are returned
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
