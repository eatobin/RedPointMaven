package RedPointMaven;

public class Rules {
    //test 1 of 3 - is giver giving to self?
    public static boolean giveeNotSelf(String giverCode, String giveeCode) {
        return !giverCode.equals(giveeCode);
    }

    //test 2 of 3 - is givee giving to giver?
    public static boolean giveeNotRecip(String giverCode, String giveeCode, Roster roster, int thisYear) {
        String giveeGivingTo;
        giveeGivingTo = roster.getGiveeCode(giveeCode, thisYear);
        return !giverCode.equals(giveeGivingTo);
    }

    //test 3 of 3 - has giver given to givee in past 4 years?
    public static boolean giveeNotRepeat(String giverCode, String giveeCode, Roster roster, int thisYear) {
        int counter;
        String giveeInYear;
        boolean result = true;
        for (counter = thisYear - 1; (counter >= 0) && (counter >= (thisYear - 4)); counter--) {
            giveeInYear = roster.getGiveeCode(giverCode, counter);
            if (giveeCode.equals(giveeInYear)) {
                result = false;
            }
        }
        return result;
    }
}
