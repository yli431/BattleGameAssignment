package team;

public interface PositionInterface {
    Athlete athlete = null; // The athlete playing in this position (not required)

    /**
     * Sets the athlete playing in this position.
     * @param athlete The athlete to set in this position.
     */
    public void setAthlete(Athlete athlete);

    /**
     * Gets the athlete playing in this position.
     * @return The athlete playing in this position.
     */
    public Athlete getAthlete();
}