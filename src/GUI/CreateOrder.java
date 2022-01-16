package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CreateOrder extends JDialog {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTypeCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateOrder frame = new CreateOrder();
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
	public CreateOrder() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(20, 20, 350, 450);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton buttonContinue = new JButton("Continue");
		buttonContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerTypeMenu customerMenu = new CustomerTypeMenu();
				customerMenu.setVisible(true);
			}
		});
		buttonContinue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonContinue.setBounds(196, 377, 130, 23);
		contentPane.add(buttonContinue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 316, 323);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton buttonSearch = new JButton("Search Inventory\r\n");
		buttonSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonSearch.setBounds(177, 10, 149, 25);
		contentPane.add(buttonSearch);
		
		txtTypeCode = new JTextField(10);
		txtTypeCode.setToolTipText("Use Enter to add item ");
		txtTypeCode.setBounds(10, 10, 149, 25);
		contentPane.add(txtTypeCode);
		//txtTypeCode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 383, 149, 14);
		contentPane.add(lblNewLabel);
		
		
	}
}
