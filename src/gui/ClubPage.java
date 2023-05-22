package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import enums.Difficulty;
import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;
import game.Match;
import team.Athlete;
import team.PositionInterface;
import team.Team;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClubPage {

	private JFrame frmClubPage;
	private JTextArea textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JTextArea textField_2;
	private Team team; // A team object
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Team team = new Team(); // Create a Team object
	                ClubPage window = new ClubPage(team);
	                window.frmClubPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param team 
	 */
	public ClubPage(Team team) {
		this.team = team;
		initialize();
	}
	
	private class PageActionListener implements ActionListener {
	    private Team team;

	    public PageActionListener(Team team) {
	        this.team = team;
	    }
	    public void actionPerformed(ActionEvent e) {
	    	if (this.team.getCurrentWeek() >= this.team.getLengthOfSeason()) {
	    		SetUpGame window = new SetUpGame();
	            window.getFrmSetUpPage().setVisible(true);
	    	}
	    	Team team_enm = new Team();
	        Match battle = new Match(this.team, team_enm);
	        String battleResult = battle.play();
	        BattleGame window = new BattleGame(this.team, battleResult);
            window.getFrmClubPage().setVisible(true);
	    }
	}
	
	private class PassActionListener implements ActionListener {
	    private Team team;

	    public PassActionListener(Team team) {
	        this.team = team;
	    }
	    public void actionPerformed(ActionEvent e) {
	    	if (this.team.getCurrentWeek() >= this.team.getLengthOfSeason()) {
	    		SetUpGame window = new SetUpGame();
	            window.getFrmSetUpPage().setVisible(true);
	    	}
	    	this.team.increaseCurrentWeek();
	    	ClubPage window = new ClubPage(this.team);
            window.getFrmClubPage().setVisible(true);
	    }
	}


	public JFrame getFrmClubPage() {
		return this.frmClubPage;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClubPage = new JFrame();
		frmClubPage.setTitle("Club Page");
		frmClubPage.setBounds(100, 100, 1096, 735);
		frmClubPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClubPage.getContentPane().setLayout(null);
		
		textField = new JTextArea();
		textField.setBounds(12, 246, 1072, 102);
		frmClubPage.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("The general information of your actively athletes: ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(22, 167, 838, 67);
		frmClubPage.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Battle now!");
		btnNewButton.setBounds(624, 588, 236, 53);
		frmClubPage.getContentPane().add(btnNewButton);
		
		JLabel lblWeek = new JLabel("Current Week:");
		lblWeek.setFont(new Font("Dialog", Font.BOLD, 20));
		lblWeek.setBounds(22, 39, 215, 33);
		frmClubPage.getContentPane().add(lblWeek);
		
		textField_1 = new JTextField();
		textField_1.setBounds(433, 30, 169, 55);
		frmClubPage.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("The general information of your reserved: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setBounds(22, 360, 838, 67);
		frmClubPage.getContentPane().add(lblNewLabel_1);
		
		textField_2 = new JTextArea();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 439, 1072, 102);
		frmClubPage.getContentPane().add(textField_2);

		StringBuilder activeAthletesInfo = new StringBuilder();
	    for (PositionInterface position : team.getGamePositions()) {
	        Athlete athlete = position.getAthlete();
	        if (athlete != null) {
	            activeAthletesInfo.append("Name: ").append(athlete.getName())
	            .append(", Offense: ").append(athlete.getOffense())
	            .append(", Defense: ").append(athlete.getDefense())
	            .append(", Stamina: ").append(athlete.getStamina())
	            .append(", Injured: ").append(athlete.getStamina() <= 0 ? "Yes" : "No")
	            .append("\n");
	        } else {
	            activeAthletesInfo.append("Position: ").append(position.getName()).append(", Athlete: None.\n");
	        }
	    }
	    textField.setText(activeAthletesInfo.toString());

	    StringBuilder reserveAthletesInfo = new StringBuilder();
	    for (PositionInterface position : team.getReservePositions()) {
	        Athlete athlete = position.getAthlete();
	        if (athlete != null) {
	            reserveAthletesInfo.append("Name: ").append(athlete.getName())
	            .append(", Offense: ").append(athlete.getOffense())
	            .append(", Defense: ").append(athlete.getDefense())
	            .append(", Stamina: ").append(athlete.getStamina())
	            .append(", Injured: ").append(athlete.getStamina() <= 0 ? "Yes" : "No")
	            .append("\n");
	        } else {
	            reserveAthletesInfo.append("Position: ").append(position.getName()).append(", Athlete: None.\n");
	        }
	    }
	    textField_2.setText(reserveAthletesInfo.toString());

	    textField_1.setText(String.valueOf(team.getCurrentWeek()));
	    
	    JLabel lblTotalWeek = new JLabel("Total Week:");
	    lblTotalWeek.setFont(new Font("Dialog", Font.BOLD, 20));
	    lblTotalWeek.setBounds(22, 105, 215, 33);
	    frmClubPage.getContentPane().add(lblTotalWeek);
	    
	    textField_3 = new JTextField();
	    textField_3.setBounds(433, 102, 171, 53);
	    frmClubPage.getContentPane().add(textField_3);
	    textField_3.setColumns(10);
	    textField_3.setText(String.valueOf(team.getLengthOfSeason()));
	    
	    JButton btnPass = new JButton("Pass");
	    btnPass.setBounds(180, 588, 236, 53);
	    frmClubPage.getContentPane().add(btnPass);
	    btnPass.addActionListener(new PassActionListener(team));
	    
	    btnNewButton.addActionListener(new PageActionListener(team));
	    
		
	    
	}
}
