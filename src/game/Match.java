package game;

import team.Athlete;
import team.DefensePosition;
import team.OffencePosition;
import team.PositionInterface;
import team.Team;

public class Match {
    private Team team1;
    private Team team2;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String play() {
    	// Initialize scores 初始化分数
        int scoreTeam1 = 0;
        int scoreTeam2 = 0;

        // Iterate over each game position and have athletes face off 迭代每个游戏位置并让运动员面对面
        for (int i = 0; i < team1.getGamePositions().size(); i++) {
            PositionInterface position1 = team1.getGamePositions().get(i);
            PositionInterface position2 = team2.getGamePositions().get(i);
            Athlete athlete1 = position1.getAthlete();
            Athlete athlete2 = position2.getAthlete();

            // Make sure the athletes are not injured 确保运动员不受伤
            if (athlete1.getStamina() > 0 && athlete2.getStamina() > 0) {
                // Depending on their position, they'll use a different skills 根据他们的位置，他们会使用不同的技能
                if (position1 instanceof OffencePosition) {
                    if (athlete1.getOffense() > athlete2.getDefense()) {
                        scoreTeam1++;
                    } else if (athlete1.getOffense() < athlete2.getDefense()) {
                        scoreTeam2++;
                    }
                    // Both athletes lose stamina. The loser loses more 两名运动员都失去了耐力, 输的人输的更多
                    athlete1.setStamina(athlete1.getStamina() - 2);
                    athlete2.setStamina(athlete2.getStamina() - 3);
                } else if (position1 instanceof DefensePosition) {
                    if (athlete1.getDefense() > athlete2.getOffense()) {
                        scoreTeam1++;
                    } else if (athlete1.getDefense() < athlete2.getOffense()) {
                        scoreTeam2++;
                    }
                    // Both athletes lose stamina. The loser loses more
                    athlete1.setStamina(athlete1.getStamina() - 2);
                    athlete2.setStamina(athlete2.getStamina() - 3);
                }
                // Check if either athlete is injured 检查任一运动员是否受伤
                if (athlete1.getStamina() <= 0) {
                    athlete1.setInjured(true);
                }
                if (athlete2.getStamina() <= 0) {
                    athlete2.setInjured(true);
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        // Display the outcome of the match 显示比赛结果
        if (scoreTeam1 > scoreTeam2) {
            result.append("Team " + team1.getName() + " wins with a score of " + scoreTeam1 + " to " + scoreTeam2 + "!");
        } else if (scoreTeam2 > scoreTeam1) {
        	result.append("Team " + team2.getName() + " wins with a score of " + scoreTeam2 + " to " + scoreTeam1 + "!");
        } else {
        	result.append("The match is a draw, with both teams scoring " + scoreTeam1 + "!");
        }
        
        return result.toString();
    }
}

