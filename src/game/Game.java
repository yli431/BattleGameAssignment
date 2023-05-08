package game;

import java.util.HashMap;

import enums.Difficulty;
import exceptions.InvalidDifficulty;

public class Game {

    private Difficulty difficulty = null;

    private HashMap<String, Difficulty> difficultyOptions = null;

    public Game(HashMap<String, Difficulty> difficultyOptions) {
        this.difficultyOptions = difficultyOptions;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String option) throws InvalidDifficulty {
        Difficulty difficulty = this.difficultyOptions.get(option);
        if (difficulty == null) {
            throw new InvalidDifficulty("option " + option + " is invalid.");
        }
        this.difficulty = difficulty;
    }

    public HashMap<String, Difficulty> getDifficultyOptions() {
        return this.difficultyOptions;
    }

    public void setDifficultyOptions(HashMap<String, Difficulty> difficultyOptions) {
        this.difficultyOptions = difficultyOptions;
    }

}
