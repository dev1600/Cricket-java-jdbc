package Query;

public class MatchResultQuery {
    public static String getInsertMatchResultQuery() {
        return insertMatchResultQuery;
    }

    private static String insertMatchResultQuery="Insert ignore into MatchResult Values(%d,%d,%d,%d,%d,%d,%d,'%s')";

}
