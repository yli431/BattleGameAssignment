package team;

import java.util.ArrayList;

import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;

public class Team {

    private String name;
    private Integer length_of_season;
    private ArrayList<PositionInterface> gamePositions;
    private ArrayList<PositionInterface> reservePositions;
    private int money = 0;

    public Team() {
        this.gamePositions = new ArrayList<PositionInterface>();
        this.gamePositions.add(new OffencePosition());
        this.gamePositions.add(new OffencePosition());
        this.gamePositions.add(new DefensePosition());
        this.gamePositions.add(new DefensePosition());

        this.reservePositions = new ArrayList<PositionInterface>();
        this.reservePositions.add(new OffencePosition());
        this.reservePositions.add(new OffencePosition());
        this.reservePositions.add(new DefensePosition());
        this.reservePositions.add(new DefensePosition());
    }

    public Integer getLength_of_season() {
        return this.length_of_season;
    }

    public void setLength_of_season(Integer length_of_season) throws LengthOfSeasonTooShort, LengthOfSeasonTooLong {
        if (length_of_season < 5) {
            throw new LengthOfSeasonTooShort(
                    "Error: Length of season too short. The length scope must be between 5 and 15.");
        }
        if (length_of_season > 15) {
            throw new LengthOfSeasonTooLong(
                    "Error: Length of season too short. The length scope must be between 5 and 15.");
        }
        this.length_of_season = length_of_season;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws TeamNameTooShort, TeamNameTooLong {
        if (name.length() < 3) {
            throw new TeamNameTooShort("Error: Team name too long. The length scope is from 3 to 15.");
        }
        if (name.length() > 15) {
            throw new TeamNameTooLong("Error: Team name too long. The length scope is from 3 to 15.");
        }
        this.name = name;
    }

    public ArrayList<PositionInterface> getReservePositions() {
        return this.reservePositions;
    }

    public void setReservePositions(ArrayList<PositionInterface> reserved) {
        this.reservePositions = reserved;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<PositionInterface> getGamePositions() {
        return this.gamePositions;
    }

    public void setGamePositions(ArrayList<PositionInterface> gamePositions) {
        this.gamePositions = gamePositions;
    }
}
