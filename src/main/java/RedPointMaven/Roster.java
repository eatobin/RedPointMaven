package RedPointMaven;

import java.util.HashMap;
import java.util.Map;

public class Roster {
    Map<String, Player> roster;

    public Roster() {
        roster = new HashMap<String, Player>();
        roster.put("EriTob", new Player("Eric Tobin", "SarArt"));
        roster.put("SarArt", new Player("Sarah Artzi", "JerCoh"));
        roster.put("JerCoh", new Player("Jerri Cohen", "EriTob"));
    }

    /**
     * How large is the roster? Used to set parameters elsewhere.
     */
    public int rosterSize() {
        return roster.size();
    }

    public String returnPlayerName(String playerCode) {
        return roster.get(playerCode).getPlayerName();
    }
}
