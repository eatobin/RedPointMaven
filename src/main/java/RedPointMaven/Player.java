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

    public String getPlayerName() {
        return playerName;
    }

    public boolean addGivee(String givee) {
        return pastGivees.add(givee);
    }

    public String returnGivee(int giftYear) {
        return pastGivees.get(giftYear);
    }

    public String setGivee(String givee, int year) {
        return pastGivees.set(year, givee);
    }
}
