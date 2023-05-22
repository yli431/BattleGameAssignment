package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import enums.Difficulty;
import exceptions.LengthOfSeasonTooLong;
import exceptions.LengthOfSeasonTooShort;
import exceptions.TeamNameTooLong;
import exceptions.TeamNameTooShort;
import team.Team;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SetUpGame {

    private JFrame frmSetUpPage;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_2;
    private JTextField textField_2;
    //private Team team;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SetUpGame window = new SetUpGame();
                    window.frmSetUpPage.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public SetUpGame() {
        initialize();
    }

    public JFrame getFrmSetUpPage() {
		return this.frmSetUpPage;
	}
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmSetUpPage = new JFrame();
        frmSetUpPage.setTitle("Set Up Page");
        frmSetUpPage.setBounds(100, 100, 1020, 751);
        frmSetUpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSetUpPage.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Welcome to the Battle Game!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        lblNewLabel.setBounds(283, 47, 479, 85);
        frmSetUpPage.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField.setBounds(736, 187, 144, 28);
        frmSetUpPage.getContentPane().add(textField);
        textField.setColumns(10);


        JLabel lblNewLabel_1 = new JLabel("Enter Your Team Name:");
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(65, 192, 317, 19);
        frmSetUpPage.getContentPane().add(lblNewLabel_1);

        JLabel lblEnterTheNumber = new JLabel("Enter the Number of Weeks You Want the Season to Last:");
        lblEnterTheNumber.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblEnterTheNumber.setBounds(65, 279, 614, 19);
        frmSetUpPage.getContentPane().add(lblEnterTheNumber);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        textField_1.setColumns(10);
        textField_1.setBounds(736, 274, 144, 28);
        frmSetUpPage.getContentPane().add(textField_1);

        lblNewLabel_2 = new JLabel("Choose a Difficulty Level:");
        lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(65, 367, 299, 28);
        frmSetUpPage.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("Show the Money You Have:");
        lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNewLabel_2_1.setBounds(65, 455, 299, 28);
        frmSetUpPage.getContentPane().add(lblNewLabel_2_1);

        textField_2 = new JTextField();
        textField_2.setBounds(736, 442, 144, 34);
        frmSetUpPage.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Easy");
        rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 15));
        rdbtnNewRadioButton.setBounds(731, 346, 149, 23);
        frmSetUpPage.getContentPane().add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Hard");
        rdbtnNewRadioButton_1.setFont(new Font("Dialog", Font.BOLD, 15));
        rdbtnNewRadioButton_1.setBounds(731, 392, 149, 23);
        frmSetUpPage.getContentPane().add(rdbtnNewRadioButton_1);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton_1);

        JButton btnNewButton = new JButton("Continue");
        btnNewButton.setBounds(261, 588, 167, 42);
		frmSetUpPage.getContentPane().setLayout(null);
        frmSetUpPage.getContentPane().add(btnNewButton);
        
        

        JButton btnNewButton_1 = new JButton("Quit");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_1.setBounds(610, 588, 167, 42);
        frmSetUpPage.getContentPane().add(btnNewButton_1);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String text = textField.getText();
                String text_1 = textField_1.getText();

                boolean isEasy = false;
                if (rdbtnNewRadioButton.isSelected()) {
                    System.out.println("Easy");
                    isEasy = true;
                } else {
                    System.out.println("Hard");
                }
                System.out.println("Team name is: " + text);

                Team myTeam = new Team();
                try {
                    myTeam.setName(text);
                    myTeam.setLengthOfSeason(Integer.parseInt(text_1));
                    
                    // Set difficulty
                    if(isEasy){
                        myTeam.setDifficulty(Difficulty.EASY);
                    } else {
                        myTeam.setDifficulty(Difficulty.HARD);
                    }
                    ClubPage window = new ClubPage(myTeam);
   	             	window.getFrmClubPage().setVisible(true);
                    // Display the money the user has
                    textField_2.setText(String.valueOf(myTeam.getMoney()));
                } catch (TeamNameTooShort | TeamNameTooLong | NumberFormatException | LengthOfSeasonTooShort |
                        LengthOfSeasonTooLong ex) {
                    //System.out.println(ex.getMessage());
                	JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }
}