//package RedPointMaven;
//
//import java.util.Scanner;
//
//class Redpoint {
//    private static final String FILE_NAME = "blackhawks2010.txt";
//    private static int year = 0;
//    private static final Roster ROSTER = new Roster(FILE_NAME);
//    private static Hat giverHat;
//    private static Hat giveeHat;
//    private static String giver;
//    private static String givee;
//
//    public static void main(String[] args) {
//        while (!printAndAsk(year).equalsIgnoreCase("q")) {
//            startNewYear();
//            while (!giver.equals("none")) {
//                while (!givee.equals("none")) {
//                    if (Rules.giveeNotSelf(giver, givee) &&
//                            Rules.giveeNotRecip(giver, givee, ROSTER, year) &&
//                            Rules.giveeNotRepeat(giver, givee, ROSTER, year)) {
//                        giveeIsSuccess();
//                    } else {
//                        giveeIsFailure();
//                    }
//                }
//                selectNewGiver();
//            }
//        }
//        System.out.println("This was fun!");
//        System.out.println("Talk about a position with Redpoint?");
//        System.out.println("Please call: Eric Tobin 773-325-1516");
//        System.out.println("Thanks! Bye...");
//    }
//
//    private static void startNewYear() {
//        year++;
//        ROSTER.addNewYear();
//        giverHat = new Hat(ROSTER.getRosterListCodes());
//        giveeHat = new Hat(ROSTER.getRosterListCodes());
//        giver = giverHat.drawPuck();
//        givee = giveeHat.drawPuck();
//    }
//
//    private static void selectNewGiver() {
//        giverHat.removePuck(giver);
//        giveeHat.returnDiscards();
//        giver = giverHat.drawPuck();
//        givee = giveeHat.drawPuck();
//    }
//
//    private static void giveeIsSuccess() {
//        ROSTER.setGiveeCode(giver, givee, year);
//        ROSTER.setGiverCode(givee, giver, year);
//        giveeHat.removePuck(givee);
//        givee = "none";
//    }
//
//    private static void giveeIsFailure() {
//        giveeHat.discardPuck(givee);
//        givee = giveeHat.drawPuck();
//    }
//
//    private static String printAndAsk(int year) {
//        Scanner scanner;
//        scanner = new Scanner(System.in);
//        String doNextYear;
//
//        ROSTER.printGivingRoster(year);
//        System.out.println();
//
//        System.out.print("Continue? ('q' to quit): ");
//        doNextYear = scanner.next();
//        System.out.println();
//
//        return doNextYear;
//    }
//}
