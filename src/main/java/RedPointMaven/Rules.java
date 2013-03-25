package RedPointMaven;

public class Rules {
    Roster myRoster;

    public static boolean giveeNotSelf(String giver, String givee) {
        return !giver.equals(givee);
    }

    public boolean giveeNotRecip(String giver, String givee, int thisYear) {
        // is givee(this year) == giver??
        givee = myRoster.returnGivee(givee, thisYear);
        return !giver.equals(givee);
    }
}
