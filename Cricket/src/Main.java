import dbconnection.Connection;
import game.Match;
import scoreboard.PrintScore;
import team.Team;
import player.Player;
import toss.*;

import java.sql.ResultSet;



public class Main {
    public static void main(String[] args) {
        Connection.connectDB();;
        Match match=new Match(20,1);
        Toss toss=new Toss(match);
        toss.doToss();
        match.getSettingTeam().setTarget(match.getFormat().getNoOfOvers()*6);
        Team teamWon=match.getChasingTeam().chaseTarget(match.getFormat().getNoOfOvers()*6,match.getSettingTeam().getTarget());
        PrintScore.printWinner(teamWon,match.getChasingTeam(),match.getSettingTeam());
        match.storeMatchResultDB();
    }
}