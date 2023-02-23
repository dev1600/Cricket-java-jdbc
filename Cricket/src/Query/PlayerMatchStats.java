package Query;

public class PlayerMatchStats {
    public static String getInsertPlayerMatchStatQuery() {
        return insertPlayerMatchStatQuery;
    }

    private static String insertPlayerMatchStatQuery="Insert ignore PlayerMatchStats Values(%d,%d,%d,%d)";
}
