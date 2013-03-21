package RedPointMaven;

/**
 * A class to track the history of gift givers and givees - by year
 * Uses an ArrayList of ArrayLists where x axis = time (year) and
 * y axis = player
 */

import java.util.*;

public class GiftHistory {
    // instance variables
    ArrayList<ArrayList<Integer>> history = new ArrayList<ArrayList<Integer>>();

    /**
     * Constructor for objects of class GiftHistory
     */
    public GiftHistory(int rosterSize) {
        /*
        initialize instance variables and
        make year 0 ArrayList for each player (given a roster size)
        */
        for (int i = 0; i < rosterSize; i++) {
            history.add(new ArrayList<Integer>());
        }

        /*
        now, add year 0 giftees
        (year = 0, i = giver, history[i] = givee)
        auto boxing to Integer
        */
        history.get(0).add(108);
        history.get(1).add(109);
        history.get(2).add(110);
        history.get(3).add(111);
        history.get(4).add(112);
        history.get(5).add(113);
        history.get(6).add(114);
        history.get(7).add(115);
        history.get(8).add(116);
        history.get(9).add(117);
        history.get(10).add(100);
        history.get(11).add(101);
        history.get(12).add(102);
        history.get(13).add(103);
        history.get(14).add(104);
        history.get(15).add(105);
        history.get(16).add(106);
        history.get(17).add(107);
    }

    /**
     * Add a year to new year to end of each player Initialized to 0 as givee
     */
    public void addYear() {
        // add a givee 0 at end of each player ArrayList
        for (ArrayList<Integer> aHistory : history) {
            aHistory.add(0);
        }
    }

    /**
     * Test #1/3 - Check to see that giver and givee are not same player
     */
    public boolean giveeNotSelf(int giver, int givee) {
        return giver != givee;
    }

    /**
     * Test #2/3 - Check to see that givee did not give this year to giver
     */
    public boolean giveeNotRecip(int giver, int givee) {
        // is givee(this year) == giver??
        int theGivee = history.get(givee - 100).get(
                (history.get(givee - 100).size()) - 1);

        return theGivee != giver;
    }

    /**
     * Test #3/3 - Check to see that givee has not received from giver in last 4
     * years
     */
    public boolean giveeNotRepeat(int giver, int givee) {
        /*
        is givee(last 4 years) == givee (this year)??
        histSize starts @ 2 and grows to 6 over first 4 years
        */
        int histSize = history.get(0).size();
        int start = 0;
        int end = histSize - 1;
        int pastGivee;
        boolean correct = true;

        if (histSize > 6) {
            start = histSize - 6;
        }

        for (int i = start; i < end; i++) {
            pastGivee = history.get(giver - 100).get(i);

            if (pastGivee == givee) {
                correct = false;
            }
        }

        return correct;
    }

    /**
     * Set the givee for the giver where year = this
     */
    public int setGivee(int giver, int givee) {
        int replaced;

        replaced = history.get(giver - 100)
                .set(((history.get(giver - 100).size()) - 1), givee);

        return replaced;
    }

    /**
     * Return this year's gift listing as an integer array
     */
    public int[] giftList(int rosterSize) {
        int[] giftList = new int[rosterSize];

        for (int i = 0; i < rosterSize; i++) {
            giftList[i] = history.get(i).get((history.get(i).size()) - 1);
        }

        return giftList;
    }
}
