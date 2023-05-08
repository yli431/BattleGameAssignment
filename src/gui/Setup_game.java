package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

public class Setup_game {

	private JFrame frmSetUpPage;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setup_game window = new Setup_game();
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
	public Setup_game() {
		initialize();
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
		textField_2.setBounds(697, 427, 246, 108);
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
	}
}
