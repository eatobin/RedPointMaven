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

    public boolean addGivee(String newGivee) {
        return pastGivees.add(newGivee);
    }

    public String returnGivee(int giftYear) {
        return pastGivees.get(giftYear);
    }
}
