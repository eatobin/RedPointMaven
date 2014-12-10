package RedPointMaven;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class Roster {
    // instance variables
    private final String teamName;
    private final int firstYear;
    // (use a TreeMap to order rosterList alphabetically by key)
    private final TreeMap<String, Player> rosterList;

    // constructor
    Roster(String teamName, int firstYear) {
        this.teamName = teamName;
        this.firstYear = firstYear;
        rosterList = new TreeMap<String, Player>();

        rosterList.put("TroBro", new Player("Troy Brouwer", "DavBol"));
        rosterList.put("AdaBur", new Player("Adam Burish", "DunKei"));
        rosterList.put("AndLad", new Player("Andrew Ladd", "JoeQue"));
        rosterList.put("AntNie", new Player("Antti Niemi", "JonToe"));
        rosterList.put("BreSea", new Player("Brent Seabrook", "KriVer"));
        rosterList.put("BryBic", new Player("Bryan Bickell", "MarHos"));
        rosterList.put("BriCam", new Player("Brian Campbell", "NikHja"));
        rosterList.put("CriHue", new Player("Cristobal Huet", "PatKan"));
        rosterList.put("DavBol", new Player("Dave Bolland", "PatSha"));
        rosterList.put("DunKei", new Player("Duncan Keith", "TomKop"));
        rosterList.put("JoeQue", new Player("Joel Quenneville", "TroBro"));
        rosterList.put("JonToe", new Player("Jonathan Toews", "AdaBur"));
        rosterList.put("KriVer", new Player("Kris Versteeg", "AndLad"));
        rosterList.put("MarHos", new Player("Marian Hossa", "AntNie"));
        rosterList.put("NikHja", new Player("Niklas Hjalmarsson", "BreSea"));
        rosterList.put("PatKan", new Player("Patrick Kane", "BryBic"));
        rosterList.put("PatSha", new Player("Patrick Sharp", "BriCam"));
        rosterList.put("TomKop", new Player("Tomas Kopecky", "CriHue"));
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
        Set<String> playerCodeKeySet = rosterList.keySet();

        for (String aKey : playerCodeKeySet) {
            this.getPlayer(aKey).addNoneGiveeCode();
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
