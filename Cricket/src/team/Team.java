package team;

import java.util.Scanner;

import Query.PlayerMatchStats;
import Query.PlayerQuery;
import player.Player;
import dbconnection.Connection;
public class Team {
    private Player[] teamPlayers;
    private String teamName;


    public Team(String teamName) {
        this.teamName = teamName;
        teamPlayers = new Player[11];
        inputTeamPlayer();
    }
    public void inputTeamPlayer(){
        Scanner dev = new Scanner(System.in);
        System.out.println("Enter PlayerId and Role of Players for Team " + teamName);
        for (int i = 0; i < 11; i++) {
            int playerId=dev.nextInt();
            String role = dev.next();
            teamPlayers[i] = new Player(playerId,role);
            Connection.executeUpdateQuery(String.format(PlayerQuery.getInsertPlayerQuery(),playerId,this.teamName,0,0,role));
        }
    }
    public String getName() {
        return teamName;
    }

    public String getCurrrentPlayerRole(int wicketsFallen) {
        return teamPlayers[wicketsFallen + 1].getRole();

    }
    public void storeCurrentPlayerRunsScored(int wicketsFallen,int runsScored){
        Connection.executeUpdateQuery(String.format(PlayerMatchStats.getInsertPlayerMatchStatQuery(),1,teamPlayers[wicketsFallen+1].getPlayerId(),runsScored,0));
        Connection.executeUpdateQuery(String.format(PlayerQuery.getUpdatePlayerRunsScoredQuery(),runsScored, teamPlayers[wicketsFallen+1].getPlayerId()));

    }


}
