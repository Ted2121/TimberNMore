package GUI;

import ConsoleUI.Menu;
import Controller.EmployeeController;
import Model.Database;

import javax.swing.*;
import java.awt.Font;
import java.util.Arrays;

public class LogInMenu extends JDialog {

	private Font titleFont = new Font("SansSerif", Font.BOLD, 20);
	//private static JPanel contentPane = new JPanel();
	private static JLabel labelUsername = new JLabel("Username:");
	private static JLabel labelPassword = new JLabel("Password:");
	private static JTextField usernameInput = new JTextField();
	private static JTextField passwordInput = new JPasswordField();
	private static JButton buttonLogin = new JButton("Login");
	private static JLabel labelLogin = new JLabel("Login");
	private static String username;
	private static String password;


	public LogInMenu() {

		setBounds(100, 100, 350, 250);

		this.setLayout(null);
		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		labelUsername.setBounds(55, 77, 67, 20);
		this.add(labelUsername);
		
		usernameInput.setBounds(117, 78, 163, 20);
		this.add(usernameInput);
		usernameInput.setColumns(10);
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		labelPassword.setBounds(55, 108, 67, 20);
		this.add(labelPassword);
				
		passwordInput.setBounds(117, 109, 163, 20);
		this.add(passwordInput);
					
		labelLogin.setBounds(134, 21, 67, 34);
		labelLogin.setFont(titleFont);
		this.add(labelLogin);
		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
		buttonLogin.setBounds(123, 160, 89, 23);
		this.add(buttonLogin);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		buttonLogin.addActionListener(e -> {
			username = usernameInput.getText();
			password = passwordInput.getText();

			if(Menu.grantAccess(username, password)) {
				this.dispose();
			}
		});

		this.setModal(true);
		this.setVisible(true);

	}


	}

