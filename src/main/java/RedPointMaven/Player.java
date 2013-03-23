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
}
