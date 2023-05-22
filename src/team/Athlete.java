package team;

import java.util.Random;


public class Athlete {
    private int offense;
    private int defense;
    private int stamina;
    private String name;
    private String nickname;
    private boolean injured;
    
    public Athlete(String name, String nickname) {
        Random random = new Random();
        this.offense = random.nextInt(8) + 1;
        this.defense = random.nextInt(8) + 1;
        this.stamina = random.nextInt(8) + 1;
        this.name = name;
        this.nickname = nickname == null?name:nickname;
    }
    
    // Injury
    public void setInjured(boolean isinjured) {
        this.injured = isinjured;
    }
    
    public void checkInjury() {
        if(this.stamina <= 0) {
            this.injured = true;
        }
    }
    
    public void reduceStamina(int amount) {
        stamina -= amount;
        if (stamina <= 0) {
            stamina = 0;
            injured = true;
        }
    }

    // Offense
    public int getOffense() {
        return this.offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }   
    
    // Defense
    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    // Stamina
    public int getStamina() {
        return this.stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Name
    public String getName() {
    	if (nickname == null) {
    		return this.name;
    	}
        return this.nickname;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Nickname
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
    	return "Athlete{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", offense=" + offense +
                ", defense=" + defense +
                ", stamina=" + stamina +
                '}';
    }
}
