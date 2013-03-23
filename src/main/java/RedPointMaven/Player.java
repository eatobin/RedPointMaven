package RedPointMaven;

import java.util.ArrayList;

public class Player {
    String playerName;
    ArrayList<Integer> pastGivees;

    public Player(String playerName, Integer gifteeYearZero) {
        this.playerName = playerName;
        pastGivees = new ArrayList<Integer>();
        pastGivees.add(0, gifteeYearZero);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean addGiftee(int newGiftee) {
        return pastGivees.add(newGiftee);
    }

    public int returnGiftee(int giftYear){
        return pastGivees.get(giftYear);
    }
}
