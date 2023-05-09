package gui;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Enter_page {

	private JFrame frmEnterpage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enter_page window = new Enter_page();
					window.frmEnterpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Enter_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnterpage = new JFrame();
		frmEnterpage.setTitle("Enter_page");
		frmEnterpage.setBounds(100, 100, 1006, 704);
		frmEnterpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Open Setup Game");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 25));
		btnNewButton.setBounds(301, 217, 359, 172);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Setup_game.main(new String[]{});
			}
		});
		frmEnterpage.getContentPane().setLayout(null);
		frmEnterpage.getContentPane().add(btnNewButton);
	}
}
