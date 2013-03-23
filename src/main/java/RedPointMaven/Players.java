package RedPointMaven;

import java.util.ArrayList;

public class Players {
    ArrayList<Player> players;

    public Players() {
        players = new ArrayList<Player>();
    }

    public boolean addPlayer(Player player) {
        return players.add(player);
    }
}
