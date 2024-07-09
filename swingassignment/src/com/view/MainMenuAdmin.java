package com.view;

import javax.swing.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.awt.EventQueue;


import com.service.*;


import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Cashier;
import com.model.Product;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainMenuAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField cIdTxt;
	private JTextField cNameTxt;
	private JTextField cPhoneTxt;
	private JTextField cAddressTxt;
	private JTextField cEmailTxt;
	private JTextField cPasswordTxt;
	private JTable table;
	private JTextField textField_9;
	private JTable table_1;
	private JTextField productIdTxt;
	private JTable table_2;
	private JTextField productNameTxt;
	private JTextField productQuantityAvailableTxt;
	private JTextField productQuantityAddedTxt;
	private JTextField productMrpTxt;
	private int pid = 0;
	private int cid = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuAdmin frame = new MainMenuAdmin();
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
	public MainMenuAdmin() {
		setTitle("Quick Mart: Admin Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 847, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(0, 0, 843, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		Border border = BorderFactory.createLineBorder(Color.ORANGE, 2);
		JLabel lblNewLabel = new JLabel(" Quick Mart");
		lblNewLabel.setBorder(border);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(22, 10, 132, 51);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		
		
		// all the frames for main menu
		
				JInternalFrame internalFrame = new JInternalFrame("Cashier");
				internalFrame.setBounds(52, 81, 724, 416);
				contentPane.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
//				internalFrame.setVisible(true);
				
				JInternalFrame internalFrame1 = new JInternalFrame("Transaction");
				internalFrame1.setBounds(52, 81, 724, 416);
				contentPane.add(internalFrame1);
				internalFrame1.getContentPane().setLayout(null);
				
				JInternalFrame internalFrame2 = new JInternalFrame("Stock");
				internalFrame2.setBounds(52, 81, 724, 416);
				contentPane.add(internalFrame2);
				internalFrame2.getContentPane().setLayout(null);
				
				JInternalFrame internalFrame3 = new JInternalFrame("Sales");
				internalFrame3.setBounds(52, 81, 724, 416);
				contentPane.add(internalFrame3);
				internalFrame3.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("💵 CASHIER");
		JLabel lblNewLabel_1_1 = new JLabel("🔍 TRANSACTION");
		JLabel lblNewLabel_1_2 = new JLabel("💵 STOCK");
		JLabel lblNewLabel_1_3 = new JLabel("😂 SALES");
		
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1.setBounds(186, 18, 110, 39);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                	internalFrame.setVisible(true);
                    internalFrame1.setVisible(false);
                    internalFrame2.setVisible(false);
                    internalFrame3.setVisible(false);
                    displayDataCashiers();
                    lblNewLabel_1.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Bill No.");
		lblNewLabel_7.setBounds(90, 41, 45, 13);
		internalFrame1.getContentPane().add(lblNewLabel_7);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String searchData = textField_9.getText().trim();
				
				BillService service = new BillServiceImpl();
				List<Bill> plist = service.searchBills(searchData);
				
				DefaultTableModel tmodel = (DefaultTableModel) table_1.getModel();
				tmodel.setRowCount(0);
				
				for(Bill p:plist) {
					tmodel.addRow(new Object[] {p.getBillNo(), p.getCustomerName(), p.getAmount(), p.getDate()});
				}
			}
			
		});
		textField_9.setBounds(174, 38, 153, 19);
		internalFrame1.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(363, 37, 85, 21);
		internalFrame1.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(90, 86, 430, 231);
		table_1 = new JTable();
		scrollPane_1.setColumnHeaderView(table_1);
		internalFrame1.setVisible(false);
		
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[]{
					"Bill No.", "Customer Name", "Amount", "Date"
				}
				));
		scrollPane_1.setViewportView(table_1);
		internalFrame1.getContentPane().add(scrollPane_1);
		
		
//		JLabel lblNewLabel_1_1 = new JLabel("🔍 TRANSACTION");
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(300, 18, 132, 39);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                	internalFrame.setVisible(false);
                    internalFrame1.setVisible(true);
                    internalFrame2.setVisible(false);
                    internalFrame3.setVisible(false);
                    lblNewLabel_1_1.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
                    displayAllBills();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
//		JLabel lblNewLabel_1_2 = new JLabel("💵 STOCK");
		lblNewLabel_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(466, 18, 97, 39);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                    internalFrame.setVisible(false);
                    internalFrame1.setVisible(false);
                    internalFrame2.setVisible(true);
                    internalFrame3.setVisible(false);
                    lblNewLabel_1_2.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
                    displayDataProducts();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		
		JLabel lblNewLabel_1_3_1 = new JLabel("EXIT");
		lblNewLabel_1_3_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(770, 17, 63, 39);
		panel.add(lblNewLabel_1_3_1);
		lblNewLabel_1_3_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                	System.exit(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
//		JLabel lblNewLabel_1_3 = new JLabel("😂 SALES");
		lblNewLabel_1_3.setBounds(573, 18, 110, 39);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    // Open the web page
                	internalFrame.setVisible(false);
                    internalFrame1.setVisible(false);
                    internalFrame2.setVisible(false);
                    internalFrame3.setVisible(true);
                    lblNewLabel_1_3.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1.setForeground(new Color(0, 0, 0));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Cashier ID");
		lblNewLabel_2.setBounds(21, 76, 96, 13);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cashier Name");
		lblNewLabel_2_1.setBounds(21, 99, 106, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setBounds(21, 122, 106, 13);
		internalFrame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Address");
		lblNewLabel_2_2.setBounds(21, 145, 65, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email ID");
		lblNewLabel_2_3.setBounds(21, 168, 84, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Password");
		lblNewLabel_2_4.setBounds(21, 191, 65, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_4);
		
//		JButton btnNewButton = new JButton("Add");
//		btnNewButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = cNameTxt.getText();
//				String phone = cPhoneTxt.getText();
//				String address = cAddressTxt.getText();
//				String email = cEmailTxt.getText();
//				String password = cPasswordTxt.getText();
//						
//				CashierService service = new CashierServiceImpl();
//				Cashier p = new Cashier();
//				p.setId(cid);
//				p.setName(name);
//				p.setPhone(phone);
//				p.setAddress(address);
//				p.setEmail(email);
//				// Encrypt the password
//		        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		        String hashedPassword = passwordEncoder.encode(password);
//				p.setPassword(hashedPassword);
//				
//				service.addCashier(p);
//				JOptionPane.showMessageDialog(null, "Cashier added successfully!");
//				displayDataCashiers();
//				cIdTxt.setText("");
//				cNameTxt.setText("");
//				cPhoneTxt.setText("");
//				cAddressTxt.setText("");
//				cEmailTxt.setText("");
//				cPasswordTxt.setText("");
//			}
//			
//		});
//		btnNewButton.setBounds(21, 247, 89, 26);
//		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select any row...");
					return;
				}
				
				int srow = table.getSelectedRow();
				int cid = (int) table.getModel().getValueAt(srow, 0);
				
				CashierService service = new CashierServiceImpl();
				service.deleteCashier(cid);
				
				JOptionPane.showMessageDialog(null, "Deletion success! 👍");
				
				displayDataCashiers();
			}
		});
		btnRemove.setBounds(166, 247, 89, 26);
		internalFrame.getContentPane().add(btnRemove);
		
		cIdTxt = new JTextField();
		cIdTxt.setBounds(139, 73, 96, 19);
		internalFrame.getContentPane().add(cIdTxt);
		cIdTxt.setColumns(10);
		
		cNameTxt = new JTextField();
		cNameTxt.setColumns(10);
		cNameTxt.setBounds(139, 96, 124, 19);
		internalFrame.getContentPane().add(cNameTxt);
		
		cPhoneTxt = new JTextField();
		cPhoneTxt.setColumns(10);
		cPhoneTxt.setBounds(139, 119, 124, 19);
		internalFrame.getContentPane().add(cPhoneTxt);
		
		cAddressTxt = new JTextField();
		cAddressTxt.setColumns(10);
		cAddressTxt.setBounds(139, 142, 124, 19);
		internalFrame.getContentPane().add(cAddressTxt);
		
		cEmailTxt = new JTextField();
		cEmailTxt.setColumns(10);
		cEmailTxt.setBounds(139, 165, 124, 19);
		internalFrame.getContentPane().add(cEmailTxt);
		
		cPasswordTxt = new JTextField();
		cPasswordTxt.setColumns(10);
		cPasswordTxt.setBounds(139, 188, 124, 19);
		cPasswordTxt.setEditable(false);
		internalFrame.getContentPane().add(cPasswordTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(338, 13, 349, 331);
		internalFrame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[]{
					"ID", "Name", "Phone", "Address", "Email", "Password"
				}
				));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_10 = new JLabel("Update Cashier Details");
		lblNewLabel_10.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_10.setBounds(43, 13, 239, 32);
		internalFrame.getContentPane().add(lblNewLabel_10);
		
		JButton btnDelete = new JButton("Update");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cashier c = new Cashier();
				c.setId(Integer.parseInt(cIdTxt.getText()));
				c.setName(cNameTxt.getText());
				c.setPhone(cPhoneTxt.getText());
				c.setAddress(cAddressTxt.getText());
				c.setEmail(cEmailTxt.getText());
				c.setPassword(cPasswordTxt.getText());
				
				CashierService service = new CashierServiceImpl();
				service.updateCashier(c);
				JOptionPane.showMessageDialog(null, "Update success!");
				displayDataCashiers();
				cIdTxt.setText("");
				cNameTxt.setText("");
				cPhoneTxt.setText("");
				cAddressTxt.setText("");
				cEmailTxt.setText("");
				cPasswordTxt.setText("");
			}
		});
		btnDelete.setBounds(50, 247, 96, 26);
		internalFrame.getContentPane().add(btnDelete);
		
		JButton btnNewButton_5 = new JButton("EDIT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Select any row!");
					return;
				}
				
				int srow = table.getSelectedRow();
				cIdTxt.setText(table.getModel().getValueAt(srow, 0).toString());
				cNameTxt.setText(table.getModel().getValueAt(srow, 1).toString());
				cPhoneTxt.setText(table.getModel().getValueAt(srow, 2).toString());
				cAddressTxt.setText(table.getModel().getValueAt(srow, 3).toString());
				cEmailTxt.setText(table.getModel().getValueAt(srow, 4).toString());
				cPasswordTxt.setText(table.getModel().getValueAt(srow, 5).toString());
			}
		});
		btnNewButton_5.setBounds(602, 354, 85, 21);
		internalFrame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_8 = new JLabel("Product ID");
		lblNewLabel_8.setBounds(10, 100, 114, 13);
		internalFrame2.getContentPane().add(lblNewLabel_8);
		
		productIdTxt = new JTextField();
		productIdTxt.setBounds(132, 97, 153, 19);
		internalFrame2.getContentPane().add(productIdTxt);
		productIdTxt.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(318, 23, 380, 268);
		internalFrame2.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setColumnHeaderView(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[]{
					"Product ID", "Product Name", "Available", "MRP"
				}
				));
		scrollPane_2.setViewportView(table_2);
		
		productNameTxt = new JTextField();
		productNameTxt.setColumns(10);
		productNameTxt.setBounds(132, 120, 153, 19);
		internalFrame2.getContentPane().add(productNameTxt);
		
		productQuantityAvailableTxt = new JTextField();
		productQuantityAvailableTxt.setColumns(10);
		productQuantityAvailableTxt.setBounds(132, 143, 153, 19);
		internalFrame2.getContentPane().add(productQuantityAvailableTxt);
		
		JLabel lblNewLabel_8_1 = new JLabel("Product Name");
		lblNewLabel_8_1.setBounds(10, 123, 114, 13);
		internalFrame2.getContentPane().add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("Quantity Available");
		lblNewLabel_8_2.setBounds(10, 146, 114, 13);
		internalFrame2.getContentPane().add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Quantity Added");
		lblNewLabel_8_2_1.setBounds(10, 169, 114, 13);
		internalFrame2.getContentPane().add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_8_2_1_1 = new JLabel("MRP");
		lblNewLabel_8_2_1_1.setBounds(10, 192, 114, 13);
		internalFrame2.getContentPane().add(lblNewLabel_8_2_1_1);
		
		productQuantityAddedTxt = new JTextField();
		productQuantityAddedTxt.setColumns(10);
		productQuantityAddedTxt.setBounds(132, 166, 153, 19);
		internalFrame2.getContentPane().add(productQuantityAddedTxt);
		
		productMrpTxt = new JTextField();
		productMrpTxt.setColumns(10);
		productMrpTxt.setBounds(132, 189, 153, 19);
		internalFrame2.getContentPane().add(productMrpTxt);
		
		JButton btnNewButton_1 = new JButton("+ New");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = productNameTxt.getText();
				int quantityAvailable = Integer.parseInt(productQuantityAddedTxt.getText());
				double mrp = Double.parseDouble(productMrpTxt.getText());			
				ProductService service = new ProductServiceImpl();
				Product p = new Product();
				p.setId(pid);
				p.setName(name);
				p.setQuantityAvailable(quantityAvailable);
				p.setMrp(mrp);
				
				service.addProduct(p);
				JOptionPane.showMessageDialog(null, "Product added successfully!");
				displayDataProducts();
				productIdTxt.setText("");
				productNameTxt.setText("");
				productQuantityAvailableTxt.setText("");
				productQuantityAddedTxt.setText("");
				productMrpTxt.setText("");
				
			}
			
		});
		btnNewButton_1.setBounds(39, 252, 85, 21);
		internalFrame2.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Product p = new Product();
				p.setId(Integer.parseInt(productIdTxt.getText()));
				p.setName(productNameTxt.getText());
				p.setQuantityAvailable(Integer.parseInt(productQuantityAvailableTxt.getText())+Integer.parseInt(productQuantityAddedTxt.getText()));
				p.setMrp(Double.parseDouble(productMrpTxt.getText()));
				
				ProductService service = new ProductServiceImpl();
				service.updateProduct(p);
				JOptionPane.showMessageDialog(null, "Update success!");
				displayDataProducts();
				productIdTxt.setText("");
				productNameTxt.setText("");
				productQuantityAvailableTxt.setText("");
				productQuantityAddedTxt.setText("");
				productMrpTxt.setText("");
			}
		});
		btnNewButton_3.setBounds(132, 252, 85, 21);
		internalFrame2.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Update Stock");
		lblNewLabel_4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_4.setBounds(80, 23, 145, 42);
		internalFrame2.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("EDIT");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_2.getSelectedRow()<0) {
					JOptionPane.showMessageDialog(null, "Select any row!");
					return;
				}
				
				int srow = table_2.getSelectedRow();
				productIdTxt.setText(table_2.getModel().getValueAt(srow, 0).toString());
				productNameTxt.setText(table_2.getModel().getValueAt(srow, 1).toString());
				productQuantityAvailableTxt.setText(table_2.getModel().getValueAt(srow, 2).toString());
				productQuantityAddedTxt.setText("0");
				productMrpTxt.setText(table_2.getModel().getValueAt(srow, 3).toString());
			}
		});
		btnNewButton_4.setBounds(613, 301, 85, 21);
		internalFrame2.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("REMOVE");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_2.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select any row...");
					return;
				}
				
				int srow = table_2.getSelectedRow();
				int pid = (int) table_2.getModel().getValueAt(srow, 0);
				
				ProductService service = new ProductServiceImpl();
				service.deleteProduct(pid);
				
				JOptionPane.showMessageDialog(null, "Deletion success! 👍");
				
				displayDataProducts();
			}
		});
		btnNewButton_6.setBounds(502, 301, 97, 21);
		internalFrame2.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_9 = new JLabel("Choose an option....");
		lblNewLabel_9.setBounds(289, 236, 254, 35);
		contentPane.add(lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		
		
	}
	private void displayDataProducts() {
		ProductService service  = new ProductServiceImpl();
		List<Product> plist = service.getAllProducts();
		
		DefaultTableModel t2model = (DefaultTableModel) table_2.getModel();
		t2model.setRowCount(0); // reset table
		
		for(Product p:plist) {
			t2model.addRow(new Object[] {p.getId(), p.getName(), p.getQuantityAvailable(), p.getMrp()});
		}
	}
	
	private void displayDataCashiers() {
		CashierService service1  = new CashierServiceImpl();
		List<Cashier> clist = service1.getAllCashiers();
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0); // reset table
		
		for(Cashier c:clist) {
			tmodel.addRow(new Object[] {c.getId(), c.getName(), c.getPhone(), c.getAddress(), c.getEmail(), c.getPassword()});
		}
	}
	
	private void displayAllBills() {
		BillService service  = new BillServiceImpl();
		List<Bill> plist = service.getAllBills();
		
		DefaultTableModel t1model = (DefaultTableModel) table_1.getModel();
		t1model.setRowCount(0); // reset table
		
		for(Bill p:plist) {
			t1model.addRow(new Object[] {p.getBillNo(), p.getCustomerName(), p.getAmount(), p.getDate()});
		}
		
	}
}
