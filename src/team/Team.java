package team;

import java.util.ArrayList;

import enums.Difficulty;
import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameInvalid;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;


public class Team {
    private String name;  // team name 球队名称
    private int lengthOfSeason;  // length of season 赛季长度
    private ArrayList<Athlete> athletes;
    private ArrayList<PositionInterface> gamePositions;  // game positions 比赛场上位置列表
    private ArrayList<PositionInterface> reservePositions;  // reserve positions 替补位置列表
    private int money;  // 球队资金
    private Difficulty difficulty;  // Set the default difficulty 选择难度
    private int CurrentWeek = 1;
    
    // constructor
    public Team() {
        this.athletes = new ArrayList<Athlete>(); // Initialize athletes list
        for (int i = 0; i < 8; i++) {
            this.athletes.add(new Athlete("Athlete" + i, "Nickname" + i)); // I'm using "Athlete" + i as name and "Nickname" + i as nickname.
        }
        
        // set up game positions 设置比赛场上位置
        this.gamePositions = new ArrayList<PositionInterface>();
        this.gamePositions.add(new OffencePosition(athletes.get(0)));
        this.gamePositions.add(new OffencePosition(athletes.get(1)));
        this.gamePositions.add(new DefensePosition(athletes.get(2)));
        this.gamePositions.add(new DefensePosition(athletes.get(3)));

        // set up reserve positions 设置替补位置
        this.reservePositions = new ArrayList<PositionInterface>();
        this.reservePositions.add(new OffencePosition(athletes.get(4)));
        this.reservePositions.add(new OffencePosition(athletes.get(5)));
        this.reservePositions.add(new DefensePosition(athletes.get(6)));
        this.reservePositions.add(new DefensePosition(athletes.get(7)));
        
        // Set the default difficulty
        this.difficulty = Difficulty.EASY;
    }
    
    // getters and setters for athletes
    public ArrayList<Athlete> getAthletes() {
        return this.athletes;
    }

    public void addAthlete(Athlete athlete) {
        this.athletes.add(athlete);
    }

    public void removeAthlete(Athlete athlete) {
        this.athletes.remove(athlete);
    }

    // getter and setter methods for team name 获取和设置球队名称的方法
    public String getName() {
        return this.name;
    }

    public void setName(String name) throws TeamNameTooShort, TeamNameTooLong {
        if (name.length() < 3) {
            throw new TeamNameTooShort("Team name should be between 3 and 15 characters long, the name you created is too short.");
        }
        if (name.length() > 15) {
            throw new TeamNameTooLong("Team name should be between 3 and 15 characters long, the name you created is too long.");
        }
        this.name = name;
    }

    // getter and setter methods for length of season 获取和设置赛季长度的方法
    public int getLengthOfSeason() {
        return this.lengthOfSeason;
    }

    public void setLengthOfSeason(int lengthOfSeason) throws LengthOfSeasonTooShort, LengthOfSeasonTooLong {
        if (lengthOfSeason < 5) {
            throw new LengthOfSeasonTooShort("The number you insert is too short, it should be between 5 and 15.");
        }
        if (lengthOfSeason > 15) {
            throw new LengthOfSeasonTooLong("The number you insert is too long, it should be between 5 and 15.");
        }
        this.lengthOfSeason = lengthOfSeason;
    }

    // getter and setter methods for game positions 获取和设置比赛场上位置的方法
    public ArrayList<PositionInterface> getGamePositions() {
        return this.gamePositions;
    }

    public void setGamePositions(ArrayList<PositionInterface> gamePositions) {
        this.gamePositions = gamePositions;
    }

    // getter and setter methods for reserve positions 获取和设置替补位置的方法
    public ArrayList<PositionInterface> getReservePositions() {
        return this.reservePositions;
    }

    public void setReservePositions(ArrayList<PositionInterface> reservePositions) {
        this.reservePositions = reservePositions;
    }

    // getter and setter methods for money 获取和设置金钱的方法
    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    // getter and setter methods for difficulty level 
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        // Adjust money based on difficulty
        switch(difficulty) {
            case EASY:
                this.money = 500;
                break;
            case HARD:
                this.money = 1000;
                break;
        }
    }

    public String displayTeamStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append("Display game positions:\n");
        for (PositionInterface athlete : this.gamePositions) {
            if (athlete != null) {
                sb.append(athlete.getName() + "\n");
            }
        }

        sb.append("\nDisplay reserve positions:\n");
        for (PositionInterface athlete : this.reservePositions) {
            if (athlete != null) {
                sb.append(athlete.getName() + "\n");
            }
        }

        return sb.toString();
    }

    public int getCurrentWeek() {
        return this.CurrentWeek;
    }
    
    public void increaseCurrentWeek(){
    	this.CurrentWeek += 1;
    }

    public Athlete[] getActiveAthletes() {
        ArrayList<Athlete> activeAthletes = new ArrayList<>();
        for (PositionInterface position : gamePositions) {
            Athlete athlete = position.getAthlete();
            if (athlete != null) {
                activeAthletes.add(athlete);
            }
        }
        return activeAthletes.toArray(new Athlete[0]);
    }

    public Athlete[] getReserveAthletes() {
        ArrayList<Athlete> reserveAthletes = new ArrayList<>();
        for (PositionInterface position : reservePositions) {
            Athlete athlete = position.getAthlete();
            if (athlete != null) {
                reserveAthletes.add(athlete);
            }
        }
        return reserveAthletes.toArray(new Athlete[0]);
    }
}