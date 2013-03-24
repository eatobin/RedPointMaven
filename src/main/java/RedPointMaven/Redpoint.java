/*
package RedPointMaven;

*/
/**
 * Main class for RedpointMaven.
 *//*


import java.util.Scanner;

*/
/*public class Redpoint {
    // main method
    public static void main(String[] args) {
        // initialize variables
        Scanner scanner = new Scanner(System.in);
        int year = 1;
        int doNextYear = 1;

        // make a new RosterOld
        RosterOld roster = new RosterOld();
        int rosterSize = roster.rosterSize();

        // make a new GiftHistory
        GiftHistory giftHistory = new GiftHistory(rosterSize);

        while (doNextYear == 1) {
            // print year x giftList
            System.out.println("Year " + year + " Gifts:");

            // print year pairings
            roster.printPairings(giftHistory.giftList(rosterSize));

            // add a new, empty year to history
            giftHistory.addYear();

            // make a giver Hat
            //Hat giverHat = new Hat(rosterSize);

            // make a givee Hat
            Hat giveeHat = new Hat(rosterSize);

            // draw a giver
            //int giver = giverHat.drawPuck();

            // draw a givee
            //int givee = giveeHat.drawPuck();

            // keep drawing givers until Hat empty
            while (giver != 0) {
                *//*
*/
/*
                keep drawing a givee for giver until all 3 tests are true.
                discard givee if test fails.
                set givee for giver when full success.
                remove givee from Hat.
                remover giver from Hat.
                replace discard givees.
                draw new giver and repeat all.
                *//*
*/
/*
                while (givee != 0) {
                    if (giftHistory.giveeNotSelf(giver, givee)) {
                        if (giftHistory.giveeNotRecip(giver, givee)) {
                            if (giftHistory.giveeNotRepeat(giver, givee)) {
                                giftHistory.setGivee(giver, givee);
                                giveeHat.removePuck(givee);
                                givee = 0;
                            } else {
                                giveeHat.discardPuck(givee);
                                givee = giveeHat.drawPuck();
                            }
                        } else {
                            giveeHat.discardPuck(givee);
                            givee = giveeHat.drawPuck();
                        }
                    } else {
                        giveeHat.discardPuck(givee);
                        givee = giveeHat.drawPuck();
                    }
                }

                giverHat.removePuck(giver);
                giveeHat.returnDiscards();
                giver = giverHat.drawPuck();
                givee = giveeHat.drawPuck();
            }

            System.out.println();

            // another year?
            System.out.print("Continue? (1 = yes, 0 = no): ");
            doNextYear = scanner.nextInt();
            year++;
            System.out.println();
        }

        // hope to hear from you!!
        System.out.println();
        System.out.println("This was fun!");
        System.out.println("Talk about a position with Redpoint?");
        System.out.println("Please call: Eric Tobin 773-325-1516");
        System.out.println("Thanks! Bye...");
    //}
//}
*/
