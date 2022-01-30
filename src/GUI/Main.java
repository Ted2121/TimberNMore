package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ItemController;
import Model.Database;
import Model.Item;

import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableItems;
	private JTextField textFieldItem;
	
	private String itemToSearch;
	private ItemController itemController = Database.getInstance().getItemController();
	private Item currentItem;
	private JTextField textFieldQuantity;
	
	private LogInMenu logInMenu;
	private JTextField textFieldPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		Database.getInstance().populateDatabase();
		//logInMenu = new LogInMenu();
		
//		String[] columnNames = {"Item name", "Price per unit", "Quantity", "Total Price"};
//		
//		String[][] data = {
//				{"test", "test1", "test2", "test3"},
//				{"test", "test1", "test2", "test3"},
//				{"test", "test1", "test2", "test3"},
//				{"test", "test1", "test2", "test3"}
//		};
//				
//		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar.add(mnNewMenu_1);
		setPreferredSize(new Dimension(1280, 1024));
		setMaximumSize(new Dimension(1280, 1024));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 640);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 800, 550);
		contentPane.add(tabbedPane);
		
		JPanel createOrderTab = new JPanel();
		tabbedPane.addTab("Create Order", null, createOrderTab, null);
		createOrderTab.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(31, 23, 211, 14);
		createOrderTab.add(lblCustomerName);
		
		textField = new JTextField();
		textField.setBounds(31, 53, 315, 19);
		createOrderTab.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 221, 429, 261);
		createOrderTab.add(scrollPane);
		
		tableItems = new JTable();
		scrollPane.setViewportView(tableItems);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(31, 83, 113, 14);
		createOrderTab.add(lblItemName);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(31, 108, 154, 20);
		createOrderTab.add(textFieldItem);
		textFieldItem.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		
		btnAddItem.setBounds(365, 105, 123, 26);
		createOrderTab.add(btnAddItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(195, 83, 55, 14);
		createOrderTab.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(195, 108, 55, 20);
		createOrderTab.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldItem.getText().equals("") 
						|| textFieldQuantity.getText().equals("") 
						|| textFieldPrice.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please fill in all available fields!");;
				}else {
					
					String data[] = {textFieldItem.getText(), 
							textFieldQuantity.getText(), 
							textFieldPrice.getText()};
					
					DefaultTableModel tblModel = (DefaultTableModel)tableItems.getModel();
					tblModel.addRow(data);
				
				}
				
			}
		});
		
		tableItems.setPreferredScrollableViewportSize(new Dimension(500, 100));
		
		JButton btnNewButton_1_4_1 = new JButton("Cancel");
		btnNewButton_1_4_1.setBounds(676, 456, 85, 26);
		createOrderTab.add(btnNewButton_1_4_1);
		
		JButton btnNewButton_1_3 = new JButton("Finalize Order");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel currentOrder = new JPanel();
				
				tabbedPane.add(currentOrder);
				
			}
		});
		btnNewButton_1_3.setBounds(531, 456, 136, 26);
		createOrderTab.add(btnNewButton_1_3);
		
		JButton btnNewButton = new JButton("Search for Item");
		btnNewButton.setBounds(31, 139, 113, 26);
		createOrderTab.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Scan Item");
		btnNewButton_1.setBounds(154, 139, 113, 26);
		createOrderTab.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Set customer");
		btnNewButton_2.setBounds(365, 49, 123, 26);
		createOrderTab.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setBounds(260, 83, 46, 14);
		createOrderTab.add(lblNewLabel);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(260, 108, 86, 20);
		createOrderTab.add(textFieldPrice);
		textFieldPrice.setColumns(10);
	}
}
