package tester;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

class Roster {
    //use a TreeMap to order rosterList alphabetically by key
    private final TreeMap<String, Player> rosterList;

    Roster() {
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

    //inner class
    private class Player {
        final String playerName;
        final ArrayList<String> pastGiveesCodes;

        private Player(String playerName, String giveeCodeYearZero) {
            this.playerName = playerName;
            pastGiveesCodes = new ArrayList<String>();
            pastGiveesCodes.add(giveeCodeYearZero);
        }

        //return playerName
        private String getPlayerName() {
            return playerName;
        }

        //return a giveeCode given a year
        private String getGiveeCode(int giftYear) {
            return pastGiveesCodes.get(giftYear);
        }

        //add a giveeCode "none" to array of past givees
        private void addNoneGiveeCode() {
            pastGiveesCodes.add("none");
        }

        //set a giveeCode in a given year
        private String setGiveeCode(String giveeCode, int year) {
            return pastGiveesCodes.set(year, giveeCode);
        }
    }

    private Player getPlayer(String playerCode) {
        return this.rosterList.get(playerCode);
    }

    String getPlayerName(String playerCode) {
        return this.getPlayer(playerCode).getPlayerName();
    }

    String getGiveeCode(String playerCode, int year) {
        return this.getPlayer(playerCode).getGiveeCode(year);
    }

    String setGiveeCode(String playerCode, String giveeCode, int year) {
        return this.getPlayer(playerCode).setGiveeCode(giveeCode, year);
    }

    //add a new empty year ("none") to each Player's givee array
    public void addNewYear() {
        Set<String> playerCodeKeySet = rosterList.keySet();

        for (String aKey : playerCodeKeySet) {
            this.getPlayer(aKey).addNoneGiveeCode();
        }
    }
}
