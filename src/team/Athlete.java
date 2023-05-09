package team;

import java.util.Random;

public class Athlete {
    private int offense;
    private int defense;
    private int stemina;
    private int exp;
    private int level;
    private String name;
    private String nickname;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String toString() {
        return "offense: " + String.valueOf(this.offense) + " defense: " + String.valueOf(this.defense) + " Stemina: "
                + String.valueOf(this.stemina) + " level: " + String.valueOf(this.level);
    }

    public Athlete() {
        Random random = new Random();

        this.offense = random.nextInt(8) + 1;
        this.defense = 10 - this.offense;
        this.stemina = 10;
        this.exp = 0;
        this.level = 1;
    }

    public int getOffense() {
        return this.offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getStemina() {
        return this.stemina;
    }

    public void setStemina(int stemina) {
        this.stemina = stemina;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}