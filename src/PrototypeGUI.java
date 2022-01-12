import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrototypeGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrototypeGUI frame = new PrototypeGUI();
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
	public PrototypeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 544);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 894, 475);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Create Order", null, panel, null);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 10, 615, 428);
		panel.add(textPane);
		
		JButton btnNewButton = new JButton("Search Items");
		btnNewButton.setBounds(698, 82, 136, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Scan Items");
		btnNewButton_1.setBounds(698, 136, 136, 43);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_3 = new JButton("Finalize Order");
		btnNewButton_1_3.setBounds(698, 252, 136, 43);
		panel.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Back");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_4.setBounds(672, 342, 85, 43);
		panel.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_4_1 = new JButton("Cancel");
		btnNewButton_1_4_1.setBounds(781, 342, 85, 43);
		panel.add(btnNewButton_1_4_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update Order", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 10, 562, 428);
		panel_1.add(textPane_1);
	}
}
