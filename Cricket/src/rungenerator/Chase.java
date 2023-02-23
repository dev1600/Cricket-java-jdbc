package rungenerator;

import scoreboard.PrintScore;
import team.Team;

public class Chase {
    private int chasingRun;
    private Team teamChasingTarget;
    private Team teamSettingTarget;
    private int wicketsLeft;
    private int ballsFaced;
    private Team teamWon;
    public Chase(Team teamChasingTarget,Team teamSettingTarget){
        this.chasingRun=0;
        this.wicketsLeft=10;
        this.teamChasingTarget=teamChasingTarget;
        this.teamSettingTarget=teamSettingTarget;
    }
    public Team getChasingTeamObject(){
        return teamChasingTarget;
    }
    public Team getTeamSettingTarget(){
        return teamSettingTarget;
    }
    public int getChasingRun() {
        return chasingRun;
    }
    public int getWickets(){
        return wicketsLeft;
    }
    public int getBallsFaced() { return ballsFaced; }

    public Team getTeamWon() {
        return teamWon;
    }

    public Team chaseTarget(int total_balls, int target) {
        int currentBall = 0;
        int currentPlayerRuns=0;
        while (currentBall <= total_balls && wicketsLeft > 0 && chasingRun < target) {
            int g = Generator.generateRuns(teamChasingTarget.getCurrrentPlayerRole(10-wicketsLeft));

            if (g == 7) {
                System.out.println("That's a WICKET!!!");
                teamChasingTarget.storeCurrentPlayerRunsScored(10-wicketsLeft,currentPlayerRuns);
                wicketsLeft--;
                currentPlayerRuns=0;

            } else {
                chasingRun += g;
                currentPlayerRuns+=g;
            }
            if (wicketsLeft == 0 || chasingRun >=target) {
                break;
            }
            ballsFaced=currentBall;
            PrintScore.printScore(chasingRun, wicketsLeft, currentBall, teamChasingTarget);
            PrintScore.printScore(target, chasingRun, wicketsLeft, total_balls - currentBall, teamChasingTarget);
            currentBall++;
        }

          return teamWon=chasingRun < target ? teamSettingTarget : teamChasingTarget;

    }
}
