package RedPointMaven;

import java.util.ArrayList;

public class Player {
    String playerName;
    ArrayList<String> pastGivees;

    public Player(String playerName, String giveeYearZero) {
        this.playerName = playerName;
        pastGivees = new ArrayList<String>();
        pastGivees.add(0, giveeYearZero);
    }

    //return playerName
    public String getPlayerName() {
        return playerName;
    }

    //add a givee to array of past givees
    public boolean addGivee(String givee) {
        return pastGivees.add(givee);
    }

    //return a givee given a year
    public String returnGivee(int giftYear) {
        return pastGivees.get(giftYear);
    }

    //set a givee in a given year
    public String setGivee(String givee, int year) {
        return pastGivees.set(year, givee);
    }
}
