package RedPointMaven;

import java.util.ArrayList;

public class Player {
    String playerName;
    ArrayList<String> pastGivees;

    public Player(String playerName, String gifteeYearZero) {
        this.playerName = playerName;
        pastGivees = new ArrayList<String>();
        pastGivees.add(0, gifteeYearZero);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean addGivee(String newGiftee) {
        return pastGivees.add(newGiftee);
    }

    public String returnGivee(int giftYear) {
        return pastGivees.get(giftYear);
    }
}
