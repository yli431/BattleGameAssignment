package team;

public class OffencePosition implements PositionInterface {
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
