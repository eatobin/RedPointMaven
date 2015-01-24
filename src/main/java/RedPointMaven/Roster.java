package RedPointMaven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

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
        private final String[] roles;
        private final ArrayList<String[]> givingHistory;
        private final int GIVEE = 0;
        private final int GIVER = 1;
//        private final ArrayList<String> pastGiversCodes;

        // constructor
        private Player(String playerName, String giveeCodeYearZero, String giverCodeCodeYearZero) {
            this.playerName = playerName;
            roles = new String[2];
            givingHistory = new ArrayList<String[]>();
            roles[GIVEE] = giveeCodeYearZero;
            roles[GIVER] = giverCodeCodeYearZero;
            givingHistory.add(roles);
        }

        // get a giftHistory given a year
        private String[] getHistory(int giftYear) {
            return givingHistory.get(giftYear);
        }

        // set a gifHistory in a given year
        private String[] setHistory(String giveeCode, String giverCode, int giftYear) {
            roles[GIVEE] = giveeCode;
            roles[GIVER] = giverCode;
            return givingHistory.set(giftYear, roles);
        }

        // add a giftHistory "none" to array of history
        private void addNoneRoleCode() {
            givingHistory.add(new String[]{"none", "none"});
        }
    }

//    // get a Player for use with public object methods
//    private Player getPlayer(String playerCode) {
//        return this.rosterList.get(playerCode);
//    }
//
//    // get playerName from returned Player
//    String getPlayerName(String playerCode) {
//        if (this.getPlayer(playerCode) != null) {
//            return this.getPlayer(playerCode).playerName;
//        } else {
//            return null;
//        }
//    }
//
//    // get giveeCode from returned Player for a given year
//    String getGiveeCode(String playerCode, int year) {
//        if (this.getPlayer(playerCode) != null) {
//            return this.getPlayer(playerCode).getGiveeCode(year);
//        } else {
//            return null;
//        }
//    }
//
//    // get giverCode from returned Player for a given year
//    String getGiverCode(String playerCode, int year) {
//        if (this.getPlayer(playerCode) != null) {
//            return this.getPlayer(playerCode).getGiverCode(year);
//        } else {
//            return null;
//        }
//    }
//
//    // set giveeCode for returned Player for a given year
//    String setGiveeCode(String playerCode, String giveeCode, int year) {
//        if (this.getPlayer(playerCode) != null) {
//            return this.getPlayer(playerCode).setGiveeCode(giveeCode, year);
//        } else {
//            return null;
//        }
//    }
//
//    // set giverCode for returned Player for a given year
//    String setGiverCode(String playerCode, String giveeCode, int year) {
//        if (this.getPlayer(playerCode) != null) {
//            return this.getPlayer(playerCode).setGiverCode(giveeCode, year);
//        } else {
//            return null;
//        }
//    }
//
//    // add a new empty year ("none") to each Player's
//    // pastGiveeCodes/pastGiverCodes ArrayLists
//    void addNewYear() {
//        Set<String> playerCodeKeySet = this.rosterList.keySet();
//
//        for (String playerCode : playerCodeKeySet) {
//            if (this.getPlayer(playerCode) != null) {
//                this.getPlayer(playerCode).addNoneGiveeCode();
//                this.getPlayer(playerCode).addNoneGiverCode();
//            }
//        }
//    }
//
//    // get rosterList of player codes
//    ArrayList<String> getRosterListCodes() {
//        return new ArrayList<String>(this.rosterList.keySet());
//    }
//
//    // get team name
//    String getTeamName() {
//        return this.teamName;
//    }
//
//    // get first year
//    int getFirstYear() {
//        return this.firstYear;
//    }
//
//    // print the giving roster for a given year
//    void printGivingRoster(int year) {
//        /*
//        uses key:value pair functionality of keySet.
//        returns a msg if no match (playerCode = "none")
//        where last giver/givee in Hats fail a test.
//        */
//        String playerName;
//        String giveeCode;
//        String giveeName;
//        String giverCode;
//        Set<String> playerCodeKeySet = rosterList.keySet();
//        ArrayList<String> noGivee = new ArrayList<String>();
//        ArrayList<String> noGiver = new ArrayList<String>();
//
//        System.out.println(getTeamName() + " - Year " + (getFirstYear() + year) + " Gifts:");
//        for (String playerCode : playerCodeKeySet) {
//            playerName = this.getPlayer(playerCode).playerName;
//            giveeCode = this.getPlayer(playerCode).getGiveeCode(year);
//            giverCode = this.getPlayer(playerCode).getGiverCode(year);
//            if (giveeCode.equals("none")) {
//                noGivee.add(playerCode);
//            } else {
//                if (this.getPlayer(giveeCode) != null) {
//                    giveeName = this.getPlayer(giveeCode).playerName;
//                } else {
//                    giveeName = "WHOA - ERROR HERE!";
//                }
//                System.out.println(playerName + " is buying for " + giveeName);
//            }
//            if (giverCode.equals("none")) {
//                noGiver.add(playerCode);
//            }
//        }
//        if (!(noGivee.size() == 0 && noGiver.size() == 0)) {
//            System.out.println();
//            System.out.println("There is a logic error in this year's pairings.");
//            System.out.println("Do you see it?");
//            System.out.println("If not... call me and I'll explain!");
//            System.out.println();
//            for (String playerCode : noGivee) {
//                playerName = this.getPlayer(playerCode).playerName;
//                System.out.println(playerName + " is giving to no one.");
//            }
//            for (String playerCode : noGiver) {
//                playerName = this.getPlayer(playerCode).playerName;
//                System.out.println(playerName + " is receiving from no one.");
//            }
//        }
//    }
}
