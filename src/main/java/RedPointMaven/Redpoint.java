package RedPointMaven;

import java.util.Scanner;

class Redpoint {

    private static int year = 0;
    private static Roster blackhawks2010 = new Roster("Blackhawks", 2010);
    private static Hat giverHat;
    private static Hat giveeHat;
    private static String giver;
    private static String givee;

    public static void main(String[] args) {
        while (printAndAsk(year, true) == 1) {
            startNewYear();
            while (!giver.equals("none")) {
                while (!givee.equals("none")) {
                    if (Rules.giveeNotSelf(giver, givee)) {
                        if (Rules.giveeNotRecip(giver, givee, blackhawks2010, year)) {
                            if (Rules.giveeNotRepeat(giver, givee, blackhawks2010, year)) {
                                giveeIsSuccess();
                            } else {
                                giveeIsFailure();
                            }
                        } else {
                            giveeIsFailure();
                        }
                    } else {
                        giveeIsFailure();
                    }
                }
                selectNewGiver();
            }
        }
        System.out.println("This was fun!");
        System.out.println("Talk about a position with Redpoint?");
        System.out.println("Please call: Eric Tobin 773-325-1516");
        System.out.println("Thanks! Bye...");
    }

    private static void startNewYear() {
        year++;
        blackhawks2010.addNewYear();
        giverHat = new Hat(blackhawks2010.getRosterListCodes());
        giveeHat = new Hat(blackhawks2010.getRosterListCodes());
        giver = giverHat.drawPuck();
        givee = giveeHat.drawPuck();
    }

    private static void selectNewGiver() {
        giverHat.removePuck(giver);
        giveeHat.returnDiscards();
        giver = giverHat.drawPuck();
        givee = giveeHat.drawPuck();
    }

    private static void giveeIsSuccess() {
        blackhawks2010.setGiveeCode(giver, givee, year);
        giveeHat.removePuck(givee);
        givee = "none";
    }

    private static void giveeIsFailure() {
        giveeHat.discardPuck(givee);
        givee = giveeHat.drawPuck();
    }

    private static int printAndAsk(int year, boolean isNotTest) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        int doNextYear;
        doNextYear = 0;

        blackhawks2010.printGivingRoster(year);
        System.out.println();

        if (isNotTest) {
            System.out.print("Continue? (1 = yes, 0 = no): ");
            doNextYear = scanner.nextInt();
            System.out.println();
        }

        return doNextYear;
    }
}
