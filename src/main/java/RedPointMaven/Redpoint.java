package RedPointMaven;

/**
 * Main class for RedpointMaven.
 */

import java.util.Scanner;

public class Redpoint {
    static Roster blackhawks2010;
    static Hat giveeHat;

    private static String giveePass(String giver, String givee, int year) {
        blackhawks2010.setGiveeCode(giver, givee, year);
        giveeHat.removePuck(givee);
        return "none";
    }

    private static String giveeFail(String givee) {
        giveeHat.discardPuck(givee);
        return giveeHat.drawPuck();
    }

    private static void applyRules(int year, String giver, String givee) {
        while (!givee.equals("none")) {
            if (Rules.giveeNotSelf(giver, givee)) {
                if (Rules.giveeNotRecip(giver, givee, blackhawks2010, year)) {
                    if (Rules.giveeNotRepeat(giver, givee, blackhawks2010, year)) {
                        givee = giveePass(giver, givee, year);
                    } else {
                        givee = giveeFail(givee);
                    }
                } else {
                    givee = giveeFail(givee);
                }
            } else {
                givee = giveeFail(givee);
            }
        }
    }

    private static int printGifts(Scanner scanner, int year) {
        int doNextYear;
        System.out.println("Year " + year + " Gifts:");
        blackhawks2010.printGivingRoster(year);
        System.out.println();
        System.out.print("Continue? (1 = yes, 0 = no): ");
        doNextYear = scanner.nextInt();
        System.out.println();
        return doNextYear;
    }

    // main method
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        int year = 0;
        int doNextYear;

        blackhawks2010 = new Roster();
        String giver;
        String givee;
        Hat giverHat;

        doNextYear = printGifts(scanner, year);

        while (doNextYear == 1) {
            year++;

            // add a new, empty year to history
            blackhawks2010.addNewYear();

            // make a giver Hat
            giverHat = new Hat(blackhawks2010);

            // make a givee Hat
            giveeHat = new Hat(blackhawks2010);

            // draw a giver
            giver = giverHat.drawPuck();

            // draw a givee
            givee = giveeHat.drawPuck();

            // keep drawing givers until Hat empty
            while (!giver.equals("none")) {
                /*
                keep drawing a givee for giver until all 3 tests are true.
                discard givee if test fails.
                set givee for giver when full success.
                remove givee from Hat.
                remover giver from Hat.
                replace discard givees.
                draw new giver and repeat all.
                */
                applyRules(year, giver, givee);
                giverHat.removePuck(giver);
                giveeHat.returnDiscards();
                giver = giverHat.drawPuck();
                givee = giveeHat.drawPuck();
            }
            doNextYear = printGifts(scanner, year);
        }

        // hope to hear from you!!
        System.out.println();
        System.out.println("This was fun!");
        System.out.println("Talk about a position with Redpoint?");
        System.out.println("Please call: Eric Tobin 773-325-1516");
        System.out.println("Thanks! Bye...");
    }
}
