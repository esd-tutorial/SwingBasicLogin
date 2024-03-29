import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;

public class Main {
	
	private ScaledImage imgVector = new ScaledImage(Main.class.getResource("/assets/login.png"), 270, 360);
	private ScaledImage imgClose = new ScaledImage(Main.class.getResource("/assets/close.png"), 16, 16);
	//Inputs
	private ScaledImage imgUsername = new ScaledImage(Main.class.getResource("/assets/username.png"), 16, 16);
	private ScaledImage imgPassword = new ScaledImage(Main.class.getResource("/assets/password.png"), 16, 16);
	//Password
	private ScaledImage imgEyeOpen = new ScaledImage(Main.class.getResource("/assets/eye-open.png"), 16, 16);
	private ScaledImage imgEyeClose = new ScaledImage(Main.class.getResource("/assets/eye-close.png"), 16, 16);
	
	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	
	private boolean viewPassword = false;
	
	private int mouseX, mouseY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(MyColor.SECONDARY);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.WHITE);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(2, 2, 596, 396);
		mainPanel.setBackground(MyColor.WHITE);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int newX = frame.getX() + e.getX() - mouseX;
				int newY = frame.getY() + e.getY() - mouseY;
				frame.setLocation(newX, newY);
			}
		});
		leftPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		leftPanel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		leftPanel.setBounds(5, 5, 290, 385);
		leftPanel.setBackground(MyColor.SECONDARY);
		mainPanel.add(leftPanel);
		leftPanel.setLayout(null);
		
		JLabel lblVector = new JLabel("");
		lblVector.setHorizontalAlignment(SwingConstants.CENTER);
		lblVector.setBounds(10, 11, 270, 363);
		lblVector.setIcon(imgVector.icon);
		leftPanel.add(lblVector);
		
		JLabel lblNewLabel = new JLabel("Login Account");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(305, 67, 281, 38);
		mainPanel.add(lblNewLabel);
		
		JLabel lblClose = new JLabel("");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to close this application?", "Confirmation", JOptionPane.WARNING_MESSAGE);
				
				if(confirmation == 0) {
					System.exit(0);
				}
			}
		});
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setBounds(567, 5, 24, 24);
		lblClose.setIcon(imgClose.icon);
		mainPanel.add(lblClose);
		
		JPanel pnlUsername = new JPanel();
		pnlUsername.setBounds(305, 131, 280, 40);
		pnlUsername.setBackground(MyColor.INPUT_BG);
		mainPanel.add(pnlUsername);
		pnlUsername.setLayout(null);
		
		JPanel pnlUsernameBorder = new JPanel();
		pnlUsernameBorder.setBounds(0, 0, 5, 40);
		pnlUsernameBorder.setBackground(MyColor.PRIMARY);
		pnlUsername.add(pnlUsernameBorder);
		
		JLabel lblUsernameIcon = new JLabel("");
		lblUsernameIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsernameIcon.setBounds(10, 5, 24, 30);
		lblUsernameIcon.setIcon(imgUsername.icon);
		pnlUsername.add(lblUsernameIcon);
		
		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				onFocusGained(txtUsername, "Username");
			}
			@Override
			public void focusLost(FocusEvent e) {
				onFocusLost(txtUsername, "Username");
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setBounds(40, 5, 230, 30);
		txtUsername.setBackground(MyColor.INPUT_BG);
		txtUsername.setForeground(MyColor.PLACEHOLDER);
		pnlUsername.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel pnlPassword = new JPanel();
		pnlPassword.setLayout(null);
		pnlPassword.setBackground(new Color(248, 248, 248));
		pnlPassword.setBounds(305, 193, 280, 40);
		mainPanel.add(pnlPassword);
		
		JPanel pnlPasswordBorder = new JPanel();
		pnlPasswordBorder.setBackground(new Color(245, 6, 255));
		pnlPasswordBorder.setBounds(0, 0, 5, 40);
		pnlPassword.add(pnlPasswordBorder);
		
		JLabel lblPasswordIcon = new JLabel("");
		lblPasswordIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordIcon.setBounds(10, 5, 24, 30);
		lblPasswordIcon.setIcon(imgPassword.icon);
		pnlPassword.add(lblPasswordIcon);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("Password");
		txtPassword.setEchoChar('\u0000');
		txtPassword.setForeground(MyColor.PLACEHOLDER);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				onFocusGained(txtPassword, "Password");
				String password = String.valueOf(txtPassword.getPassword());
				txtPassword.setEchoChar(password.equals("Password")? '\u0000' : '•');
			}
			@Override
			public void focusLost(FocusEvent e) {
				onFocusLost(txtPassword, "Password");
				String password = String.valueOf(txtPassword.getPassword());
				txtPassword.setEchoChar(password.equals("Password")? '\u0000' : '•');
			}
		});
		txtPassword.setBorder(null);
		txtPassword.setBounds(40, 5, 210, 30);
		txtPassword.setBackground(MyColor.INPUT_BG);
		pnlPassword.add(txtPassword);
		
		JLabel lblViewPassword = new JLabel("");
		lblViewPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(viewPassword) {
					txtPassword.setEchoChar('•');
					lblViewPassword.setIcon(imgEyeClose.icon);
					viewPassword = false;
				}
				else {
					txtPassword.setEchoChar('\u0000');
					lblViewPassword.setIcon(imgEyeOpen.icon);
					viewPassword = true;
				}
			}
		});
		lblViewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPassword.setBounds(250, 5, 24, 30);
		lblViewPassword.setIcon(imgEyeOpen.icon);
		pnlPassword.add(lblViewPassword);
		
		JCheckBox chkRemember = new JCheckBox("Remember Me");
		chkRemember.setFont(new Font("Arial", Font.PLAIN, 9));
		chkRemember.setBounds(301, 239, 153, 23);
		chkRemember.setBackground(MyColor.WHITE);
		mainPanel.add(chkRemember);
		
		JLabel lblNewLabel_1 = new JLabel("Forgot Password?");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 9));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(475, 243, 111, 14);
		mainPanel.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = String.valueOf(txtPassword.getPassword());
				
				username = username.equals("Username") ? "" : username;
				password = password.equals("Password") ? "" : password;
				
				if(username.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Please complete all requirements", "Message", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if(username.equals("admin") && password.equals("password123")) {
					JOptionPane.showMessageDialog(null, "Login Success", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Login Failed", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogin.setBounds(305, 291, 281, 38);
		btnLogin.setBackground(MyColor.PRIMARY);
		btnLogin.setForeground(MyColor.WHITE);
		mainPanel.add(btnLogin);
	}
	
	private void onFocusGained(JTextField field, String placeholder) {
		if(field.getText().equals(placeholder)) {
			field.setText("");
		}
		
		field.setForeground(MyColor.BLACK);
	}
	
	private void onFocusLost(JTextField field, String placeholder) {
		if(field.getText().equals("")) {
			field.setText(placeholder);
			field.setForeground(MyColor.PLACEHOLDER);
		}
	}
}
