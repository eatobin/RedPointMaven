package RedPointMaven;

import java.util.Scanner;

public class Redpoint {
    static Roster blackhawks2010;
    static Hat giveeHat;
    static int doNextYear;

    public static void main(String[] args) {
        int year = 0;
        blackhawks2010 = new Roster();
        String giver;
        String givee;
        Hat giverHat;

        while (printGiftsAndNext(year) == 1) {
            year++;
            blackhawks2010.addNewYear();
            giverHat = new Hat(blackhawks2010);
            giveeHat = new Hat(blackhawks2010);
            giver = giverHat.drawPuck();
            givee = giveeHat.drawPuck();
            while (!giver.equals("none")) {
                testGivee(year, giver, givee);

                giverHat.removePuck(giver);
                giveeHat.returnDiscards();
                giver = giverHat.drawPuck();
                givee = giveeHat.drawPuck();
            }
        }
        System.out.println("This was fun!");
        System.out.println("Talk about a position with Redpoint?");
        System.out.println("Please call: Eric Tobin 773-325-1516");
        System.out.println("Thanks! Bye...");
    }

    private static String giveePass(String giver, String givee, int year) {
        blackhawks2010.setGiveeCode(giver, givee, year);
        giveeHat.removePuck(givee);
        return "none";
    }

    private static String giveeFail(String givee) {
        giveeHat.discardPuck(givee);
        return giveeHat.drawPuck();
    }

    private static void testGivee(int year, String giver, String givee) {
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

    private static int printGiftsAndNext(int year) {
        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.println("Year " + year + " Gifts:");
        blackhawks2010.printGivingRoster(year);
        System.out.println();
        System.out.print("Continue? (1 = yes, 0 = no): ");
        doNextYear = scanner.nextInt();
        System.out.println();
        return doNextYear;
    }
}
