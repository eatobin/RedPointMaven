package RedPointMaven;

import java.util.HashMap;
import java.util.Map;

public class Roster2 {
    Map<String, Player> roster;

    public Roster2() {
        roster = new HashMap<String, Player>();

        roster.put("EriTob", new Player("Eric Tobin", 56));
    }

    /*public boolean addPlayer(Player player) {
        return players.add(player);
    }*/
}
