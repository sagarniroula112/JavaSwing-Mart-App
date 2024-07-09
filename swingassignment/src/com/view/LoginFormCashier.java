package com.view;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFormCashier extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginFormCashier() {
		setTitle("Quick Mart App: Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 563, 390);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 105, 86, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(77, 156, 86, 29);
		contentPane.add(lblNewLabel_1);
		
		usernameTxt = new JTextField();
		usernameTxt.setBounds(166, 109, 183, 27);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		passwordTxt = new JTextField();
		passwordTxt.setBounds(166, 160, 183, 27);
		contentPane.add(passwordTxt);
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Welcome().setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(148, 226, 118, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Invalid attempt!");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setBounds(77, 82, 86, 13);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = usernameTxt.getText();
				String pw = passwordTxt.getText();
				System.out.println(un);
				System.out.println(pw);
				
				if(authenticateUser(un, pw)) {
					
					new MainMenu().setVisible(true);
					dispose();
					
				}else {
					lblNewLabel_4.setVisible(true);
				}
				
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton_1.setBounds(283, 226, 118, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("<html><a style='color: white;' href=''>Click here to register</a></html>");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                    new RegisterForm().setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(203, 304, 223, 28);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 549, 37);
		contentPane.add(panel);
		panel.setBackground(new Color(255, 153, 0));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Login Form");
		lblNewLabel_2.setBounds(10, 0, 133, 34);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		
	}
	
//	private boolean authenticateUser(String email, String password) {
//	    boolean isAuthenticated = false;
//	    String url = "jdbc:mysql://localhost:3306/javadb";
//	    String dbUser = "root";
//	    String dbPassword = "hello";
//	    
//	    try {
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//	        Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
//	        
//	        String query = "SELECT * FROM cashier WHERE email = ? AND password = ?";
//	        PreparedStatement pst = con.prepareStatement(query);
//	        pst.setString(1, email);
//	        pst.setString(2, password);
//	        
//	        ResultSet rs = pst.executeQuery();
//	        
//	        if (rs.next()) {
//	            isAuthenticated = true;
//	        }
//	        
//	        rs.close();
//	        pst.close();
//	        con.close();
//	    } catch (Exception ex) {
//	        ex.printStackTrace();
//	    }
//	    
//	    return isAuthenticated;
//	}
	
	private boolean authenticateUser(String email, String password) {
	    boolean isAuthenticated = false;
	    String url = "jdbc:mysql://localhost:3306/javadb";
	    String dbUser = "root";
	    String dbPassword = "hello";
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
	        
	        String query = "SELECT password FROM cashier WHERE email = ?";
	        PreparedStatement pst = con.prepareStatement(query);
	        pst.setString(1, email);
	        
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            String hashedPasswordFromDB = rs.getString("password");
	            
	            // Use BCryptPasswordEncoder to verify the password
	            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	            isAuthenticated = passwordEncoder.matches(password, hashedPasswordFromDB);
	        }
	        
	        rs.close();
	        pst.close();
	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    
	    return isAuthenticated;
	}

}
