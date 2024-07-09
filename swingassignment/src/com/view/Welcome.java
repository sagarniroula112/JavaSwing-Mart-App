package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Quick Mart: Welcome");
		setBounds(100, 100, 822, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Super Market Billing System");
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 27));
		lblNewLabel.setBounds(118, 36, 520, 49);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon("marketlogo.png");
		JLabel icoLabel = new JLabel(icon);
		icoLabel.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(icoLabel);

      
		
		JButton btnNewButton = new JButton("Admin Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBounds(503, 167, 164, 56);
//		btnNewButton.setBorder(new RoundedBorder(20)); // Set the border radius
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cashier Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFormCashier().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton_1.setBounds(503, 285, 164, 56);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quick Mart");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_2.setBounds(130, 204, 250, 73);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("-----------------------------------------------------------------------------------------------------------------------------------------");
		lblNewLabel_3.setBounds(103, 81, 552, 13);
		contentPane.add(lblNewLabel_3);
	}
}
