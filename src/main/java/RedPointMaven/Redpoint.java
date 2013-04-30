package RedPointMaven;

public class Redpoint {

    public static void main(String[] args) {
        int year = 0;
        Roster blackhawks2010;
        blackhawks2010 = new Roster();
        Hat giverHat;
        Hat giveeHat;
        String giver;
        String givee;

        while (blackhawks2010.printAndAsk(year) == 1) {

            year++;
            blackhawks2010.addNewYear();
            giverHat = new Hat(blackhawks2010);
            giveeHat = new Hat(blackhawks2010);
            giver = giverHat.drawPuck();
            givee = giveeHat.drawPuck();

            while (!giver.equals("none")) {

                while (!givee.equals("none")) {
                    if (Rules.giveeNotSelf(giver, givee)) {
                        if (Rules.giveeNotRecip(giver, givee, blackhawks2010, year)) {
                            if (Rules.giveeNotRepeat(giver, givee, blackhawks2010, year)) {
                                blackhawks2010.setGiveeCode(giver, givee, year);
                                giveeHat.removePuck(givee);
                                givee = "none";
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

        }

        System.out.println("This was fun!");
        System.out.println("Talk about a position with Redpoint?");
        System.out.println("Please call: Eric Tobin 773-325-1516");
        System.out.println("Thanks! Bye...");
    }
}
