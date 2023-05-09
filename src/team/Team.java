package team;

import java.util.ArrayList;

import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;

// Team class is used for "set up page"
public class Team {

    // instance variables
    private String name;
    private int lengthOfSeason;
    private ArrayList<PositionInterface> gamePositions;
    private ArrayList<PositionInterface> reservePositions;
    private int money;

    // constructor
    public Team() {
        // set up game positions
        this.gamePositions = new ArrayList<PositionInterface>();
        this.gamePositions.add(new OffencePosition());
        this.gamePositions.add(new OffencePosition());
        this.gamePositions.add(new DefensePosition());
        this.gamePositions.add(new DefensePosition());

        // set up reserve positions
        this.reservePositions = new ArrayList<PositionInterface>();
        this.reservePositions.add(new OffencePosition());
        this.reservePositions.add(new OffencePosition());
        this.reservePositions.add(new DefensePosition());
        this.reservePositions.add(new DefensePosition());
    }

    // getter and setter methods for team name
    public String getName() {
        return this.name;
    }

    public void setName(String name) throws TeamNameTooShort, TeamNameTooLong {
        if (name.length() < 3) {
            throw new TeamNameTooShort("Error: Team name too short. The length must be between 3 and 15.");
        }
        if (name.length() > 15) {
            throw new TeamNameTooLong("Error: Team name too long. The length must be between 3 and 15.");
        }
        this.name = name;
    }

    // getter and setter methods for length of season
    public int getLengthOfSeason() {
        return this.lengthOfSeason;
    }

    public void setLengthOfSeason(int lengthOfSeason) throws LengthOfSeasonTooShort, LengthOfSeasonTooLong {
        if (lengthOfSeason < 5) {
            throw new LengthOfSeasonTooShort("Error: Length of season too short. The length must be between 5 and 15.");
        }
        if (lengthOfSeason > 15) {
            throw new LengthOfSeasonTooLong("Error: Length of season too long. The length must be between 5 and 15.");
        }
        this.lengthOfSeason = lengthOfSeason;
    }

    // getter and setter methods for game positions
    public ArrayList<PositionInterface> getGamePositions() {
        return this.gamePositions;
    }

    public void setGamePositions(ArrayList<PositionInterface> gamePositions) {
        this.gamePositions = gamePositions;
    }

    // getter and setter methods for reserve positions
    public ArrayList<PositionInterface> getReservePositions() {
        return this.reservePositions;
    }

    public void setReservePositions(ArrayList<PositionInterface> reservePositions) {
        this.reservePositions = reservePositions;
    }

    // getter and setter methods for money
    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
