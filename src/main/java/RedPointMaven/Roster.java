package RedPointMaven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Roster {
    // instance variables
    private String teamName;
    private int firstYear;
    private final TreeMap<String, Player> rosterList; // (use a TreeMap to order rosterList alphabetically by key)

    // constructor
    Roster(String fileName) {
        BufferedReader br;
        String s;
        List<String> stringList;
        teamName = null;
        firstYear = 0;
        rosterList = new TreeMap<String, Player>();

        // read each line from file and depending upon length, assign values
        // to team name, roster year or a Player
        try {
            br = new BufferedReader(
                    new FileReader(fileName));
            try {
                while ((s = br.readLine()) != null) {
                    stringList = Arrays.asList(s.split(", "));
                    if (stringList.size() == 2) {
                        this.teamName = stringList.get(0);
                        this.firstYear = Integer.parseInt(stringList.get(1));
                    } else {
                        rosterList.put(stringList.get(0), new Player(stringList.get(1), stringList.get(2), stringList.get(3)));
                    }
                }
            } finally {
                br.close();
            }
        } catch (IOException ex) {
            System.out.println("File Read Error");
        }
    }

    // inner class Player
    private class Player {
        private final String playerName;
        private final ArrayList<HashMap<String, String>> giftHistory;

        // constructor
        private Player(String playerName, String giveeCodeYearZero, String giverCodeCodeYearZero) {
            this.playerName = playerName;
            giftHistory = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> roles = new HashMap<String, String>();
            roles.put("GIVEE", giveeCodeYearZero);
            roles.put("GIVER", giverCodeCodeYearZero);
            giftHistory.add(roles);
        }
    }

    // get a Player for use with public object methods
    private Player getPlayer(String playerCode) {
        return this.rosterList.get(playerCode);
    }

    String getGiveeCode(String playerCode, int giftYear) {
        if (this.getPlayer(playerCode) == null) {
            return null;
        } else {
            return this.getPlayer(playerCode).giftHistory.get(giftYear).get("GIVEE");
        }
    }

    String setGiveeCode(String playerCode, String seteeCode, int giftYear) {
        if (this.getPlayer(playerCode) == null || this.getPlayer(seteeCode) == null) {
            return null;
        } else {
            HashMap<String, String> roles = getPlayer(playerCode).giftHistory.get(giftYear);
            roles.put("GIVEE", seteeCode);
            getPlayer(playerCode).giftHistory.set(giftYear, roles);
            return this.getPlayer(playerCode).giftHistory.get(giftYear).get("GIVEE");
        }
    }

    String getGiverCode(String playerCode, int giftYear) {
        if (this.getPlayer(playerCode) == null) {
            return null;
        } else {
            return this.getPlayer(playerCode).giftHistory.get(giftYear).get("GIVER");
        }
    }

    String setGiverCode(String playerCode, String seteeCode, int giftYear) {
        if (this.getPlayer(playerCode) == null || this.getPlayer(seteeCode) == null) {
            return null;
        } else {
            HashMap<String, String> roles = getPlayer(playerCode).giftHistory.get(giftYear);
            roles.put("GIVER", seteeCode);
            getPlayer(playerCode).giftHistory.set(giftYear, roles);
            return this.getPlayer(playerCode).giftHistory.get(giftYear).get("GIVER");
        }
    }

    // add a new empty year ("none") to each Player's
    // pastGiveeCodes/pastGiverCodes ArrayLists
    void addNewYear() {
        Set<String> playerCodeKeySet = this.rosterList.keySet();

        for (String playerCode : playerCodeKeySet) {
            if (this.getPlayer(playerCode) == null) {
                return;
            } else {
                HashMap<String, String> roles = new HashMap<String, String>();
                roles.put("GIVEE", "none");
                roles.put("GIVER", "none");
                getPlayer(playerCode).giftHistory.add(roles);
            }
        }
    }

    // get rosterList of player codes
    ArrayList<String> getRosterListCodes() {
        return new ArrayList<String>(this.rosterList.keySet());
    }

    // print the giving roster for a given year
    void printGivingRoster(int giftYear) {
        /*
        uses key:value pair functionality of keySet.
        returns a msg if no match (playerCode = "none")
        where last giver/givee in Hats fail a test.
        */
        String playerName;
        String giveeCode;
        String giverCode;
        Set<String> playerCodeKeySet = rosterList.keySet();
        ArrayList<String> noGivee = new ArrayList<String>();
        ArrayList<String> noGiver = new ArrayList<String>();

        System.out.println(this.teamName + " - Year " + (this.firstYear + giftYear) + " Gifts:");
        for (String playerCode : playerCodeKeySet) {
            playerName = this.getPlayer(playerCode).playerName;
            giveeCode = this.getGiveeCode(playerCode, giftYear);
            giverCode = this.getGiverCode(playerCode, giftYear);

            if (giveeCode.equals("none")) {
                noGivee.add(playerCode);
            } else {
                System.out.println(playerName + " is buying for " + this.getPlayer(giveeCode).playerName);
            }
            if (giverCode.equals("none")) {
                noGiver.add(playerCode);
            }
        }

        if ((noGivee.size() + noGiver.size()) > 0) {
            System.out.println();
            System.out.println("There is a logic error in this year's pairings.");
            System.out.println("Do you see it?");
            System.out.println("If not... call me and I'll explain!");
            System.out.println();
            for (String playerCode : noGivee) {
                playerName = this.getPlayer(playerCode).playerName;
                System.out.println(playerName + " is giving to no one.");
            }
            for (String playerCode : noGiver) {
                playerName = this.getPlayer(playerCode).playerName;
                System.out.println(playerName + " is receiving from no one.");
            }
        }
    }
}
