package RedPointMaven;

class Rules {

    //test 1 of 3 - is giver giving to self?
    static boolean giveeNotSelf(String giverCode, String giveeCode) {
        return !giverCode.equals(giveeCode);
    }

    //test 2 of 3 - is givee giving to giver?
    static boolean giveeNotRecip(String giverCode, String giveeCode, Roster roster, int thisYear) {
        String giveeGivingTo;
        giveeGivingTo = roster.getRoledPlayerCode(giveeCode, thisYear, "GIVEE");
        return !giverCode.equals(giveeGivingTo);
    }

    //test 3 of 3 - has giver given to givee in past X years?
    static boolean giveeNotRepeat(String giverCode, String giveeCode, Roster roster, int thisYear) {
        final int PAST_X_YEARS = 4;
        int counter;
        String giveeInYear;
        boolean result = true;
        for (counter = thisYear - 1; (counter >= 0) && (counter >= (thisYear - PAST_X_YEARS)); counter--) {
            giveeInYear = roster.getRoledPlayerCode(giverCode, counter, "GIVEE");
            if (giveeCode.equals(giveeInYear)) {
                result = false;
            }
        }
        return result;
    }
}
