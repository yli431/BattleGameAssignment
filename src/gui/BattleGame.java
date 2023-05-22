package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import game.Match;
import team.Team;

import javax.swing.JButton;

public class BattleGame {

	private JFrame frmPlaygame;
	private JTextField textField;
	private Team team;
	private String result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String str = "";
					Team tem = new Team();
					BattleGame window = new BattleGame(tem, str);
					window.frmPlaygame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BattleGame(Team team, String result) {
		this.team = team;
		this.result = result;
		initialize();
	}

	private class PageActionListener implements ActionListener {
	    private Team team;

	    public PageActionListener(Team team) {
	        this.team = team;
	    }
	    public void actionPerformed(ActionEvent e) {
	    	this.team.increaseCurrentWeek();
	    	ClubPage window = new ClubPage(this.team);
            window.getFrmClubPage().setVisible(true);
	    }
	}

	public JFrame getFrmClubPage() {
		return this.frmPlaygame;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlaygame = new JFrame();
		frmPlaygame.setTitle("Play Game Page");
		frmPlaygame.setBounds(100, 100, 1132, 783);
		frmPlaygame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlaygame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The description of the match:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(96, 40, 358, 64);
		frmPlaygame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(95, 129, 871, 218);
		frmPlaygame.getContentPane().add(textField);
		textField.setColumns(10);
	    textField.setText(result);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBounds(96, 398, 117, 25);
		frmPlaygame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new PageActionListener(this.team));
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(848, 398, 117, 25);
		frmPlaygame.getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
	}
}
