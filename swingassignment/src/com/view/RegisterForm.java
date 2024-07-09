package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.model.Cashier;
import com.service.CashierService;
import com.service.CashierServiceImpl;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class RegisterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cNameTxt;
	private JTextField cPhoneTxt;
	private JTextField cEmailTxt;
	private JTextField cPasswordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setTitle("Quick Mart App: Register");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 602, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel.setBounds(77, 103, 86, 29);
		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel_1 = new JLabel("Last Name:");
//		lblNewLabel_1.setForeground(new Color(255, 255, 255));
//		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//		lblNewLabel_1.setBounds(77, 144, 86, 29);
//		contentPane.add(lblNewLabel_1);
		
		JTextArea cAddressTxt = new JTextArea();
		cAddressTxt.setBounds(185, 185, 223, 54);
		contentPane.add(cAddressTxt);
		
		cPasswordTxt = new JTextField();
		cPasswordTxt.setColumns(10);
		cPasswordTxt.setBounds(185, 306, 223, 27);
		contentPane.add(cPasswordTxt);
		
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBackground(new Color(255, 102, 51));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton.setBounds(162, 399, 111, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = cNameTxt.getText();
				String phone = cPhoneTxt.getText();
				String address = cAddressTxt.getText();
				String email = cEmailTxt.getText();
				String password = cPasswordTxt.getText();
						
				CashierService service = new CashierServiceImpl();
				Cashier p = new Cashier();
				p.setId(0);
				p.setName(name);
				p.setPhone(phone);
				p.setAddress(address);
				p.setEmail(email);
				// Encrypt the password
		        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		        String hashedPassword = passwordEncoder.encode(password);
				p.setPassword(hashedPassword);
				
				service.addCashier(p);
				JOptionPane.showMessageDialog(null, "Cashier added successfully!");
				cNameTxt.setText("");
				cPhoneTxt.setText("");
				cAddressTxt.setText("");
				cEmailTxt.setText("");
				cPasswordTxt.setText("");
			}
		});
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnNewButton_1.setBounds(317, 399, 111, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("<html><a style='color: white;' href=''>Click here to log in</a></html>");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                    new LoginFormCashier().setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(224, 457, 148, 19);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 588, 37);
		contentPane.add(panel);
		panel.setBackground(new Color(255, 153, 0));
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Registration Form");
		lblNewLabel_2.setBounds(10, 0, 236, 34);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		
		cNameTxt = new JTextField();
		cNameTxt.setBounds(185, 105, 223, 27);
		contentPane.add(cNameTxt);
		cNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(77, 302, 86, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(77, 265, 86, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Address:");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(77, 185, 86, 29);
		contentPane.add(lblNewLabel_1_3_1);
		
		cPhoneTxt = new JTextField();
		cPhoneTxt.setColumns(10);
		cPhoneTxt.setBounds(185, 144, 223, 27);
		contentPane.add(cPhoneTxt);
		
		cEmailTxt = new JTextField();
		cEmailTxt.setColumns(10);
		cEmailTxt.setBounds(185, 267, 223, 27);
		contentPane.add(cEmailTxt);
		
		
		
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblPhone.setBounds(77, 144, 86, 29);
		contentPane.add(lblPhone);
		
		
	}
}
