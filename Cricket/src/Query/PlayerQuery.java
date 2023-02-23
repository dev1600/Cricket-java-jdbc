package Query;

public class PlayerQuery {
    private static String insertPlayerQuery ="Insert ignore into Player Values (%d,'%s',%d,%d,'%s')";
    private static String UpdatePlayerRunsScoredQuery ="Update Player set RunsScored=RunsScored+%d where PlayerId=%d";

    public static String getUpdatePlayerRunsScoredQuery() {
        return UpdatePlayerRunsScoredQuery;
    }
    public static String getInsertPlayerQuery(){
        return insertPlayerQuery;
    }

}
