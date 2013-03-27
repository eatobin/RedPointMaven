package RedPointMaven;

import java.util.Set;
import java.util.TreeMap;

public class Roster {
    TreeMap<String, Player> roster;

    public Roster() {
        roster = new TreeMap<String, Player>();
        roster.put("AdaBur", new Player("Adam Burish", "DunKei"));
        roster.put("AndLad", new Player("Andrew Ladd", "JoeQue"));
        roster.put("AntNie", new Player("Antti Niemi", "JonToe"));
        roster.put("BreSea", new Player("Brent Seabrook", "KriVer"));
        roster.put("BryBic", new Player("Bryan Bickell", "MarHos"));
        roster.put("BriCam", new Player("Brian Campbell", "NikHja"));
        roster.put("CriHue", new Player("Cristobal Huet", "PatKan"));
        roster.put("DavBol", new Player("Dave Bolland", "PatSha"));
        roster.put("DunKei", new Player("Duncan Keith", "TomKop"));
        roster.put("JoeQue", new Player("Joel Quenneville", "TroBro"));
        roster.put("JonToe", new Player("Jonathan Toews", "AdaBur"));
        roster.put("KriVer", new Player("Kris Versteeg", "AndLad"));
        roster.put("MarHos", new Player("Marian Hossa", "AntNie"));
        roster.put("NikHja", new Player("Niklas Hjalmarsson", "BreSea"));
        roster.put("PatKan", new Player("Patrick Kane", "BryBic"));
        roster.put("PatSha", new Player("Patrick Sharp", "BriCam"));
        roster.put("TomKop", new Player("Tomas Kopecky", "CriHue"));
        roster.put("TroBro", new Player("Troy Brouwer", "DavBol"));
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

    public String setGivee(String playerCode, String givee, int year) {
        return roster.get(playerCode).setGivee(givee, year);
    }

    public String returnGivee(String playerCode, int year) {
        return roster.get(playerCode).returnGivee(year);
    }

    public void addNewYear() {
        Set<String> myKeySet = roster.keySet();
        for (String aKey : myKeySet) {
            roster.get(aKey).addGivee("none");
        }
    }

    public void printGivingRoster(int year) {
        /*
        uses key:value pair functionality of keySet
        returns a msg if no match (playerNum = 0)
        where last giver/givee in Hats fail a test.
        */
        String giveeName;
        String playerName;
        String giveeCode;
        Set<String> myKeySet;
        myKeySet = roster.keySet();
        for (String aKey : myKeySet) {
            playerName = roster.get(aKey).getPlayerName();
            giveeCode = roster.get(aKey).returnGivee(year);
            if (giveeCode.equals("none")) {
                giveeName = "...nobody!! (last giver/givee pairing and a test failed - a puzzle logic error)";
            } else {
                giveeName = roster.get(giveeCode).getPlayerName();
            }
            System.out.println(playerName + " is buying for " + giveeName);
        }
    }
}
