//package GUI;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import java.awt.Font;
//
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.SwingConstants;
//
//public class CustomerLogInMenu extends JDialog {
//
//	Font titleFont = new Font("SansSerif", Font.BOLD, 20);
//	private static JPanel contentPane = new JPanel();
//	private static JLabel labelUsername = new JLabel("Username:");
//	private static JLabel labelID = new JLabel("ID:");
//	private static JTextField textUsername = new JTextField();
//	private static JButton buttonLogin = new JButton("Login");
//	private static JLabel labelLogin = new JLabel("Identify Customer");
//	private JTextField textId;
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LogInMenu frame = new LogInMenu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public CustomerLogInMenu() {
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 350, 250);
//
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		labelUsername.setHorizontalAlignment(SwingConstants.RIGHT);
//		labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
//
//		labelUsername.setBounds(39, 77, 67, 20);
//		contentPane.add(labelUsername);
//
//		textUsername.setBounds(117, 78, 163, 20);
//		contentPane.add(textUsername);
//		textUsername.setColumns(10);
//		labelID.setHorizontalAlignment(SwingConstants.RIGHT);
//		labelID.setFont(new Font("Tahoma", Font.PLAIN, 13));
//
//		labelID.setBounds(39, 108, 67, 20);
//		contentPane.add(labelID);
//		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
//
//		labelLogin.setBounds(66, 21, 203, 34);
//		labelLogin.setFont(titleFont);
//		contentPane.add(labelLogin);
//		buttonLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
//
//		buttonLogin.setBounds(123, 160, 89, 23);
//		contentPane.add(buttonLogin);
//
//		textId = new JTextField();
//		textId.setBounds(117, 109, 163, 20);
//		contentPane.add(textId);
//		textId.setColumns(10);
//	}
//}
