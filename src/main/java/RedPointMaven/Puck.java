package RedPointMaven;

import java.util.ArrayList;

public class Puck {
    String playerName;
    ArrayList<Integer> pastGivees;

    public Puck(String playerName, Integer gifteeYearZero) {
        this.playerName = playerName;
        pastGivees = new ArrayList<Integer>();
        pastGivees.add(0, gifteeYearZero);
    }
}
