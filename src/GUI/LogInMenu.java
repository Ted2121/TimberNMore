package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogInMenu extends JFrame {

	Font titleFont = new Font("SansSerif", Font.BOLD, 20);
	private static JPanel contentPane = new JPanel(); 
	private static JLabel labelUsername = new JLabel("Username:");
	private static JLabel labelPassword = new JLabel("Password:");
	private static JTextField textUsername = new JTextField();
	private static JPasswordField passwordField = new JPasswordField();
	private static JButton buttonLogin = new JButton("Login");
	private static JLabel labelLogin = new JLabel("Login");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInMenu frame = new LogInMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		labelUsername.setBounds(55, 77, 67, 20);
		contentPane.add(labelUsername);
		
		textUsername.setBounds(117, 78, 163, 20);
		contentPane.add(textUsername);
		textUsername.setColumns(10);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		labelPassword.setBounds(55, 108, 67, 20);
		contentPane.add(labelPassword);
				
		passwordField.setBounds(117, 109, 163, 20);
		contentPane.add(passwordField);
					
		labelLogin.setBounds(134, 21, 67, 34);
		labelLogin.setFont(titleFont);
		contentPane.add(labelLogin);
				
		buttonLogin.setBounds(123, 160, 89, 23);
		contentPane.add(buttonLogin);
	}
}
