/**
 * Represents a player in a battle team.
 */
public class Player {
    private final String name; // The player's name.
    private final int offence; // The player's offensive capability.
    private final int defence; // The player's defensive capability.
    private final int stamina; // The player's stamina level.
    private String nickname; // The player's nickname, if any.

    /**
     * Creates a new Player object with the specified name, offence, defence, and stamina.
     *
     * @param name the name of the player
     * @param offence the player's offensive capability
     * @param defence the player's defensive capability
     * @param stamina the player's stamina level
     */
    public Player(String name, int offence, int defence, int stamina) {
        this.name = name;
        this.offence = offence;
        this.defence = defence;
        this.stamina = stamina;
    }

    /**
     * Sets the player's nickname.
     *
     * @param nickname the player's nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the player's name.
     *
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the player's offensive capability.
     *
     * @return the player's offensive capability
     */
    public int getOffence() {
        return offence;
    }

    /**
     * Gets the player's defensive capability.
     *
     * @return the player's defensive capability
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Gets the player's stamina level.
     *
     * @return the player's stamina level
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Gets the player's experience level.
     *
     * @return the player's experience level
     */
    public int getExperience_level() {
        return 0;
    }

    /**
     * Gets the player's nickname, or their name if no nickname has been set.
     *
     * @return the player's nickname, or their name if no nickname has been set
     */
    public String getNickname() {
        if (nickname == null) {
            return name;
        } else {
            return nickname;
        }
    }
}