package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.List;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderMenu extends JFrame {
	
	private static JMenuBar menuBar;
	private static JMenu menuFile;
	private static JMenu menuEdit;
	private static JPanel contentPane;
	private static JTabbedPane tabbedPane;
	private static JPanel panel;
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public OrderMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 894, 475);
		contentPane.add(tabbedPane);
		
		
		
		
			
				
		panel = new JPanel();
		tabbedPane.addTab("Create Order", null, panel, null);
		panel.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 28, 580, 364);
		panel.add(textPane);
		
		JButton btnNewButton = new JButton("Scan item");
		btnNewButton.setBounds(600, 43, 146, 40);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Search for items");
		button.setBounds(600, 106, 146, 40);
		panel.add(button);
		
		JButton buttonUpdateOrder = new JButton("Update Order");
		buttonUpdateOrder.setBounds(600, 293, 146, 40);
		panel.add(buttonUpdateOrder);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setBounds(657, 369, 89, 23);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(10, 3, 145, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton buttonSearch = new JButton("Search by name");
		buttonSearch.setBounds(165, 2, 111, 23);
		panel.add(buttonSearch);
		

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update Order", null, panel_1, null);
		panel_1.setLayout(null);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 10, 562, 428);
		panel_1.add(textPane_1);
		
	}
	
}
