package GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerTypeMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public CustomerTypeMenu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton buttonCancel = new JButton("Cancel");
			buttonCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			buttonCancel.setBounds(173, 214, 89, 25);
			contentPanel.add(buttonCancel);
			buttonCancel.setActionCommand("Cancel");
		}
		
		JButton buttonRegestered = new JButton("Regestered Customer");
		buttonRegestered.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerLogInMenu loginprompt = new CustomerLogInMenu();
				loginprompt.setVisible(true);
			}
		});
		buttonRegestered.setBounds(123, 74, 190, 52);
		contentPanel.add(buttonRegestered);
		
		JButton buttonGuest = new JButton("Guest");
		buttonGuest.setBounds(123, 137, 190, 52);
		contentPanel.add(buttonGuest);
		
		JLabel labelCutomerType = new JLabel("Choose customer type");
		labelCutomerType.setHorizontalAlignment(SwingConstants.CENTER);
		labelCutomerType.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelCutomerType.setBounds(86, 25, 263, 24);
		contentPanel.add(labelCutomerType);
	}
}
