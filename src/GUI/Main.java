package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableItems;
	private JTextField textField_1;

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
		String[] columnNames = {"Item name", "Price per unit", "Quantity", "Total Price"};
		
		String[][] data = {
				{"test", "test1", "test2", "test3"},
				{"test", "test1", "test2", "test3"},
				{"test", "test1", "test2", "test3"},
				{"test", "test1", "test2", "test3"}
		};
				
		
		
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
		
		tableItems = new JTable(data, columnNames);
		scrollPane.setViewportView(tableItems);
		
		JLabel lblItemName = new JLabel("Item Name");
		lblItemName.setBounds(31, 83, 113, 14);
		createOrderTab.add(lblItemName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(31, 108, 305, 20);
		createOrderTab.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddItem.setBounds(355, 107, 89, 23);
		createOrderTab.add(btnAddItem);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
	}
}
