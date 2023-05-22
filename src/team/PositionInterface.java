package team;

public interface PositionInterface {
    Athlete athlete = null; // The athlete playing in this position (not required)

    /**
     * Sets the athlete playing in this position. 设置此位置上的运动员。
     * @param athlete The athlete to set in this position.
     */
    public void setAthlete(Athlete athlete);

    /**
     * Gets the athlete playing in this position. 获取此位置上的运动员。
     * @return The athlete playing in this position.
     */
    public Athlete getAthlete();

	public String getName();
}