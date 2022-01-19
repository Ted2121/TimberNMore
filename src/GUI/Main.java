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
		
		setPreferredSize(new Dimension(1920, 1080));
		setMaximumSize(new Dimension(1920, 1080));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1012, 673);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 986, 622);
		contentPane.add(tabbedPane);
		
		JPanel createOrderTab = new JPanel();
		tabbedPane.addTab("Create Order", null, createOrderTab, null);
		createOrderTab.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(31, 23, 211, 14);
		createOrderTab.add(lblCustomerName);
		
		textField = new JTextField();
		textField.setBounds(31, 53, 305, 19);
		createOrderTab.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 221, 305, 261);
		createOrderTab.add(scrollPane);
		
		tableItems = new JTable();
		scrollPane.setViewportView(tableItems);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(31, 83, 113, 14);
		createOrderTab.add(lblItemName);
		
		textFieldItem = new JTextField();
		textFieldItem.setBounds(31, 108, 219, 20);
		createOrderTab.add(textFieldItem);
		textFieldItem.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		
		btnAddItem.setBounds(356, 107, 89, 23);
		createOrderTab.add(btnAddItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(260, 83, 46, 14);
		createOrderTab.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(260, 108, 86, 20);
		createOrderTab.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldItem.getText().equals("") || textFieldQuantity.getText().equals("")) {
					JOptionPane.showMessageDialog(panel_1, "Please fill in all available fields!");;
				}else {
					itemToSearch = String.valueOf(textFieldItem.getText());
					currentItem = itemController.getSearchedItem(itemToSearch);
					String data[] = {currentItem.getItemName(), 
							String.valueOf(currentItem.getPrice()), 
							String.valueOf(lblQuantity.getText()), 
							String.valueOf(currentItem.getPrice().doubleValue() * Double.valueOf(lblQuantity.getText()))};
					
					DefaultTableModel tblModel = (DefaultTableModel)tableItems.getModel();
					tblModel.addRow(data);
				
				}
				
			}
		});
		
		tableItems.setPreferredScrollableViewportSize(new Dimension(500, 100));
	}
}
