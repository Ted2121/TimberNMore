package GUI;

import javax.swing.*;
import java.awt.Font;

public class CreateOrder extends JTabbedPane {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTypeCode;


	public CreateOrder(int top) {

		contentPane = new JPanel();

		contentPane.setLayout(null);
		this.setBounds(20, 20, 350, 450);

//		JButton buttonContinue = new JButton("Continue");
//		buttonContinue.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CustomerTypeMenu customerMenu = new CustomerTypeMenu();
//				customerMenu.setVisible(true);
//			}
//		});
//		buttonContinue.setFont(new Font("Tahoma", Font.PLAIN, 13));
//		buttonContinue.setBounds(196, 377, 130, 23);
//		contentPane.add(buttonContinue);
//
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



		this.setVisible(true);

		
	}
}
