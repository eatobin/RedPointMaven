package RedPointMaven;

public class Rules {
    public static boolean giveeNotSelf(String giver, String givee) {
        return !giver.equals(givee);
    }

    public static boolean giveeNotRecip(String giver, String givee, Roster roster, int thisYear) {
        // is givee(this year) == giver??
        String giveeGivingTo;
        giveeGivingTo = roster.returnGivee(givee, thisYear);
        return !giver.equals(giveeGivingTo);
    }

    public static boolean giveeNotRepeat(String giver, String givee, Roster roster, int thisYear) {
        int counter;
        String giveeInYear;
        boolean result = true;
        for (counter = thisYear - 1; (counter >= 0) && (counter >= (thisYear - 4)); counter--) {
            giveeInYear = roster.returnGivee(giver, counter);
            if (givee.equals(giveeInYear)) {
                result = false;
            }
        }
        return result;
    }
}
