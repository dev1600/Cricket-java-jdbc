package game;
import Query.MatchResultQuery;
import dbconnection.Connection;
import format.Format;
import team.Team;
import scoreboard.PrintScore;
import rungenerator.*;

public class Match {
    private int matchId;
    private Format format;
    private Team teamA;
    private Team teamB;

    private Target settingTeam;
    private Chase  chasingTeam;
    private Team teamWon;

    public int getMatchId() {
        return matchId;
    }

    public Match(int overs, int matchId) {
        teamA = new Team("A");
        teamB = new Team("B");
        format = new Format();
        this.matchId=matchId;
        format.setNoOfOvers(overs);
    }
    public Team getTeamA(){
        return teamA;
    }
    public Team getTeamB(){
        return teamB;
    }
    public Format getFormat() {
        return format;
    }

    public Target getSettingTeam() {
        return settingTeam;
    }

    public Chase getChasingTeam() {
        return chasingTeam;
    }
    public void setChasingTeam(Chase chasingTeam ){
        this.chasingTeam=chasingTeam;
    }
    public void setTargetTeam(Target settingTeam){
        this.settingTeam=settingTeam;
    }

    public void setTeamWon(Team teamWon) {
        this.teamWon = teamWon;
    }

    public void storeMatchResultDB(){
        Connection.executeUpdateQuery(String.format(MatchResultQuery.getInsertMatchResultQuery(),this.getMatchId(),getSettingTeam().getTarget(),
                getChasingTeam().getChasingRun(),getSettingTeam().getWicketsLeft(),getChasingTeam().getWickets(),
                getSettingTeam().getBallsFaced(),getChasingTeam().getBallsFaced(),chasingTeam.getTeamWon().getName()));
    }

}
