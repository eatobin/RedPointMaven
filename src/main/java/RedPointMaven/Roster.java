package RedPointMaven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Roster {
    // instance variables
    private String teamName = null;
    private int firstYear = 0;
    private final TreeMap<String, Player> rosterList; // (use a TreeMap to order rosterList alphabetically by key)

    // constructor
    Roster(String fileName) {
        BufferedReader br;
        String s;
        List<String> stringList;
        rosterList = new TreeMap<String, Player>();

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
                        rosterList.put(stringList.get(0), new Player(stringList.get(1), stringList.get(2)));
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
        private final ArrayList<String> pastGiveesCodes;

        // constructor
        private Player(String playerName, String giveeCodeYearZero) {
            this.playerName = playerName;
            pastGiveesCodes = new ArrayList<String>();
            pastGiveesCodes.add(giveeCodeYearZero);
        }

        // return playerName
        private String getPlayerName() {
            return playerName;
        }

        //return a giveeCode given a year
        private String getGiveeCode(int giftYear) {
            return pastGiveesCodes.get(giftYear);
        }

        // add a giveeCode "none" to array of past givees
        private void addNoneGiveeCode() {
            pastGiveesCodes.add("none");
        }

        // set a giveeCode in a given year
        private String setGiveeCode(String giveeCode, int year) {
            return pastGiveesCodes.set(year, giveeCode);
        }
    }

    // get a Player for use with public object methods
    private Player getPlayer(String playerCode) {
        return this.rosterList.get(playerCode);
    }

    // get playerName from returned Player
    String getPlayerName(String playerCode) {
        if (this.getPlayer(playerCode) != null) {
            return this.getPlayer(playerCode).getPlayerName();
        } else {
            return null;
        }
    }

    // get giveeCode from returned Player for a given year
    String getGiveeCode(String playerCode, int year) {
        if (this.getPlayer(playerCode) != null) {
            return this.getPlayer(playerCode).getGiveeCode(year);
        } else {
            return null;
        }
    }


    // set giveeCode for returned Player for a given year
    String setGiveeCode(String playerCode, String giveeCode, int year) {
        if (this.getPlayer(playerCode) != null) {
            return this.getPlayer(playerCode).setGiveeCode(giveeCode, year);
        } else {
            return null;
        }
    }

    // add a new empty year ("none") to each Player's pastGiveeCodes ArrayList
    void addNewYear() {
        Set<String> playerCodeKeySet = this.rosterList.keySet();

        for (String playerCode : playerCodeKeySet) {
            this.getPlayer(playerCode).addNoneGiveeCode();
        }
    }

    // get rosterList of player codes
    ArrayList<String> getRosterListCodes() {
        return new ArrayList<String>(this.rosterList.keySet());
    }

    // get team name
    String getTeamName() {
        return this.teamName;
    }

    // get first year
    int getFirstYear() {
        return this.firstYear;
    }

    // print the giving roster for a given year
    void printGivingRoster(int year) {
        /*
        uses key:value pair functionality of keySet.
        returns a msg if no match (playerCode = "none")
        where last giver/givee in Hats fail a test.
        */
        String playerName;
        String giveeCode;
        String giveeName;
        Set<String> playerCodeKeySet = rosterList.keySet();

        System.out.println(getTeamName() + " - Year " + (getFirstYear() + year) + " Gifts:");
        for (String aKey : playerCodeKeySet) {
            playerName = this.getPlayer(aKey).getPlayerName();
            giveeCode = this.getPlayer(aKey).getGiveeCode(year);
            if (giveeCode.equals("none")) {
                giveeName = "...nobody!! (last giver/givee pairing and a test failed - a puzzle logic error)";
            } else {
                giveeName = this.getPlayer(giveeCode).playerName;
            }
            System.out.println(playerName + " is buying for " + giveeName);
        }
    }
}
