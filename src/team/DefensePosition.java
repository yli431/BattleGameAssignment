package team;

public class DefensePosition implements PositionInterface {
    private Athlete athlete;

    public DefensePosition(Athlete athlete) {
        // You can put any initialization code here.
    	this.athlete = athlete;
    }

    @Override
    public String getName() {
        // This should return the name of the position or athlete, depending on your requirements.
        return "DefensePosition";
    }

    @Override
    public void setAthlete(Athlete athlete) {
        // Add validation or other logic as needed.
        this.athlete = athlete;
    }

    @Override
    public Athlete getAthlete() {
        // Add validation or other logic as needed.
        return this.athlete;
    }

    // Add any other methods required by PositionInterface.
}
