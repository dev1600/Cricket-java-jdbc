package rungenerator;

import scoreboard.PrintScore;
import team.Team;
public class Target {
    private int target;
    private Team teamName;
    private int wicketsLeft;
    private int ballsFaced;
    public Target(Team teamName){
        this.teamName=teamName;
        this.target=0;
    }
    public int getWicketsLeft() {
        return wicketsLeft;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public Team getSettingTeamObject(){
        return teamName;
    }
    public int getTarget(){
        return target;
    }
    public void setTarget(int total_balls) {
        int wickets_left = 10;
        int curr = 0;
        int currentPlayerRuns=0;

        while (curr < total_balls && wickets_left > 0) {
            int g = Generator.generateRuns(teamName.getCurrrentPlayerRole(10-wickets_left));

            if (g == 7) {
                System.out.println("That's a WICKET!!!");
                teamName.storeCurrentPlayerRunsScored(10-wickets_left,currentPlayerRuns);
                wickets_left--;
                currentPlayerRuns=0;
            } else {
                target += g;
                currentPlayerRuns+=g;
            }

            curr++;
            PrintScore.printScore(target, wickets_left, curr, teamName);
        }
        wicketsLeft=wickets_left;
        ballsFaced=curr;
    }

}
