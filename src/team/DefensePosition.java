package team;

public class DefensePosition implements PositionInterface {
    private Athlete athlete = null;

    @Override
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @Override
    public Athlete getAthlete() {
        return this.athlete;
    }
}
