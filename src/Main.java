import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import enums.Difficulty;
import exceptions.InvalidDifficulty;
import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;
import exceptions.UnknownPositionType;
import game.Game;
import team.Athlete;
import team.DefensePosition;
import team.OffencePosition;
import team.PositionInterface;
import team.Team;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            Team team = new Team();

            // Set the team name
            while (true) {
                System.out.println("Choose a team name:");
                String teamName = scanner.nextLine();
                try {
                    team.setName(teamName);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type.");
                    continue;
                } catch (TeamNameTooShort e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (TeamNameTooLong e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }

            // Set the length of season
            while (true) {
                System.out.println("Choose desired length of season:");
                try {
                    team.setLengthOfSeason(Integer.valueOf(scanner.nextLine()));
                } catch (LengthOfSeasonTooShort e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (LengthOfSeasonTooLong e) {
                    System.out.println(e.getMessage());
                    continue;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input type.");
                    continue;
                }
                break;
            }

            // Choose 4 athletes
            ArrayList<Athlete> athletes_candidates = new ArrayList<Athlete>();
            for (int i = 1; i <= 10; i++) {
                Athlete athlete = new Athlete();
                athletes_candidates.add(athlete);
            }

            int offence_position_count = 0;
            int defence_position_count = 0;

            for (PositionInterface position : team.getGamePositions()) {
                System.out.println("Current Athlete candidates: ");
                for (int i = 0; i < athletes_candidates.size(); i++) {
                    Athlete candidate = athletes_candidates.get(i);
                    System.out.println("Athlete number " + String.valueOf(i + 1) + ":");
                    System.out.println(candidate.toString());
                }
                while (true) {
                    if (position instanceof OffencePosition) {
                        System.out.println("Choose athlete for your " + String.valueOf(offence_position_count + 1)
                                + " offence position:");
                    } else if (position instanceof DefensePosition) {
                        System.out.println("Choose athlete for your " + String.valueOf(defence_position_count + 1)
                                + " defense position:");
                    } else {
                        throw new UnknownPositionType("Unknown position type: " + position.getClass().toString());
                    }

                    int input_number = 0;
                    try {
                        input_number = Integer.valueOf(scanner.nextLine());
                        position.setAthlete(athletes_candidates.get(input_number - 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input type. Input must be a integer");
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Input athlete number '" + String.valueOf(input_number) + "' is invalid.");
                        continue;
                    }

                    if (position instanceof OffencePosition) {
                        offence_position_count += 1;
                    } else {
                        defence_position_count += 1;
                    }

                    athletes_candidates.remove(input_number - 1);
                    break;
                }
            }

            // Choose 4 reserves
            ArrayList<Athlete> reserve_candidates = new ArrayList<Athlete>();
            for (int i = 1; i <= 10; i++) {
                Athlete athlete = new Athlete();
                reserve_candidates.add(athlete);
            }

            int offence_reserve_count = 0;
            int defence_reserve_count = 0;

            for (PositionInterface reserve_position : team.getReservePositions()) {
                System.out.println("Current reserved athlete candidates: ");
                for (int i = 0; i < reserve_candidates.size(); i++) {
                    Athlete candidate = reserve_candidates.get(i);
                    System.out.println("Athlete number " + String.valueOf(i + 1) + ":");
                    System.out.println(candidate.toString());
                }
                while (true) {
                    if (reserve_position instanceof OffencePosition) {
                        System.out.println("Choose athlete for your " + String.valueOf(offence_reserve_count + 1)
                                + " reserve offence position:");
                    } else if (reserve_position instanceof DefensePosition) {
                        System.out.println("Choose athlete for your " + String.valueOf(defence_reserve_count + 1)
                                + " reserve defense position:");
                    } else {
                        throw new UnknownPositionType(
                                "Unknown position type: " + reserve_position.getClass().toString());
                    }

                    int input_number = 0;
                    try {
                        input_number = Integer.valueOf(scanner.nextLine());
                        reserve_position.setAthlete(reserve_candidates.get(input_number - 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input type. Input must be a integer");
                        continue;
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(
                                "Input reserved athlete number '" + String.valueOf(input_number) + "' is invalid.");
                        continue;
                    }

                    if (reserve_position instanceof OffencePosition) {
                        offence_reserve_count += 1;
                    } else {
                        defence_reserve_count += 1;
                    }

                    reserve_candidates.remove(input_number - 1);
                    break;
                }
            }

            HashMap<String, Difficulty> difficulty_mapper = new HashMap<String, Difficulty>();
            difficulty_mapper.put("1", Difficulty.EASY);
            difficulty_mapper.put("2", Difficulty.HARD);
            Game game = new Game(difficulty_mapper);

            // Choose a difficulty
            while (true) {
                System.out.println("Choose desired number for difficulty from options below:");
                for (HashMap.Entry<String, Difficulty> entry : game.getDifficultyOptions().entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }

                String inputDifficultyChoice = scanner.nextLine();
                try {

                    game.setDifficulty(inputDifficultyChoice);
                } catch (InvalidDifficulty e) {
                    System.out.println("Invalid input difficulty option: " + inputDifficultyChoice);
                    continue;
                }
                break;
            }

            System.out.println();
            System.out.println();
            System.out.println("========== Initialize summary ==========");
            System.out.println("Team name is: " + team.getName());
            System.out.println("Length of season is: " + team.getLengthOfSeason());
            System.out.println("Official game positions:");
            for (PositionInterface position : team.getGamePositions()) {
                System.out.println("Position type: " + position.getClass().toString());
                System.out.println("Athlete: " + position.getAthlete().toString());
            }
            System.out.println("Reserved positions:");
            for (PositionInterface position : team.getReservePositions()) {
                System.out.println("Position type: " + position.getClass().toString());
                System.out.println("Athlete: " + position.getAthlete().toString());
            }
            System.out.println("Difficulty: " + game.getDifficulty().toString());
            System.out.println("========================================");
        }
    }
}
