package team;

public class DefensePosition implements PositionInterface {
    private Athlete athlete = null; // The athlete playing in this position
    
    /**
     * Sets the athlete playing in this position.
     * @param athlete The athlete to set in this position.
     */
    @Override
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }
    
    /**
     * Gets the athlete playing in this position.
     * @return The athlete playing in this position.
     */
    @Override
    public Athlete getAthlete() {
        return this.athlete;
    }
}
