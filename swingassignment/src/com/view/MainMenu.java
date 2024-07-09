package com.view;

import java.awt.EventQueue;
import javax.swing.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import com.service.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Product;
import com.model.ProductsInBill;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
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
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
	
	private static final int BILL_NUMBER_LENGTH = 6;
    private static final Set<String> generatedBillNumbers = new HashSet<>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField billNoTxt;
	private JTextField customerNameTxt;
	private JTextField productMrpTxt2;
	private JTextField productQuantityTxt2;
	private JTextField productDiscountTxt2;
	private JTextField dateTxt;
	private JTable table;
	private JTextField totalBillAmtTxt;
	private JTextField textField_9;
	private JTable table_1;
	private JTextField searchProductTxt;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					System.out.println("Hello");
					MainMenu frame = new MainMenu();
//					String name = loggedInCashier;
//					System.out.println(name);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static String generateUniqueBillNumber() {
        Random random = new Random();
        String billNo;
        do {
            billNo = generateRandomBillNumber(random);
        } while (generatedBillNumbers.contains(billNo));

        generatedBillNumbers.add(billNo);
        return billNo;
    }

    private static String generateRandomBillNumber(Random random) {
        StringBuilder sb = new StringBuilder(BILL_NUMBER_LENGTH);
        for (int i = 0; i < BILL_NUMBER_LENGTH; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Quick Mart: Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
				JInternalFrame internalFrame = new JInternalFrame("Create Bill");
				internalFrame.setBounds(91, 91, 647, 388);
				contentPane.add(internalFrame);
				internalFrame.getContentPane().setLayout(null);
//				internalFrame.setVisible(false);
				
				JInternalFrame internalFrame1 = new JInternalFrame("Search Bill");
				internalFrame1.setBounds(91, 91, 647, 388);
				contentPane.add(internalFrame1);
				internalFrame1.getContentPane().setLayout(null);
				
				JInternalFrame internalFrame2 = new JInternalFrame("Product Information");
				internalFrame2.setBounds(91, 95, 647, 388);
				contentPane.add(internalFrame2);
				internalFrame2.getContentPane().setLayout(null);
				
				JLabel lblNewLabel_8 = new JLabel("Product Name");
				lblNewLabel_8.setBounds(88, 41, 114, 13);
				internalFrame2.getContentPane().add(lblNewLabel_8);
				
				searchProductTxt = new JTextField();
				searchProductTxt.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent e) {
						String searchData = searchProductTxt.getText().trim();
						
						ProductService service = new ProductServiceImpl();
						List<Product> plist = service.searchProduct(searchData);
						
						DefaultTableModel tmodel = (DefaultTableModel) table_2.getModel();
						tmodel.setRowCount(0);
						
						for(Product p:plist) {
							tmodel.addRow(new Object[] {p.getId(), p.getName(), p.getQuantityAvailable(), p.getMrp()});
						}
					}
					
				});
				searchProductTxt.setBounds(203, 38, 153, 19);
				internalFrame2.getContentPane().add(searchProductTxt);
				searchProductTxt.setColumns(10);
				
				JButton btnNewButton_3 = new JButton("Search");
				btnNewButton_3.setBounds(400, 37, 85, 21);
				internalFrame2.getContentPane().add(btnNewButton_3);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				scrollPane_2.setBounds(88, 81, 435, 230);
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
				
				JInternalFrame internalFrame3 = new JInternalFrame("Sales");
				internalFrame3.setBounds(91, 95, 647, 388);
				contentPane.add(internalFrame3);
				internalFrame3.getContentPane().setLayout(null);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("💵 CREATE BILL");
		JLabel lblNewLabel_1_1 = new JLabel("🔍 SEARCH BILL");
		JLabel lblNewLabel_1_2 = new JLabel("💵 PRODUCT INFORMATION");
		JLabel lblNewLabel_1_3 = new JLabel("😂 SALES");
		
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1.setBounds(177, 22, 117, 39);
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
                    lblNewLabel_1.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
                    
                    
       
                    displayDataProductsInBill();
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
		
		
		
		lblNewLabel_1_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(297, 22, 117, 39);
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
		
		
		lblNewLabel_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(424, 22, 216, 39);
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
                    displayDataProducts();
                    lblNewLabel_1_2.setForeground(new Color(255, 153, 0));
                    lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1.setForeground(new Color(0, 0, 0));
                    lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
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
		
		
		lblNewLabel_1_3.setBounds(630, 22, 110, 39);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
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
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Bill No.");
		lblNewLabel_2.setBounds(33, 51, 45, 13);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Customer Name");
		lblNewLabel_2_1.setBounds(33, 298, 106, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Name");
		lblNewLabel_2_2.setBounds(33, 104, 45, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("MRP");
		lblNewLabel_2_3.setBounds(33, 127, 45, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Quantity");
		lblNewLabel_2_4.setBounds(33, 150, 65, 13);
		internalFrame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_4 = new JLabel("Discount");
		lblNewLabel_4.setBounds(33, 173, 65, 13);
		internalFrame.getContentPane().add(lblNewLabel_4);
		
		JComboBox<String> productNameTxt2 = new JComboBox<String>();
		productNameTxt2.setBounds(139, 100, 124, 21);
		internalFrame.getContentPane().add(productNameTxt2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				int quantity = Integer.parseInt(productQuantityTxt2.getText());
				double mrp = Double.parseDouble(productMrpTxt2.getText());
				String name = (String) productNameTxt2.getSelectedItem();
				double discount = Double.parseDouble(productDiscountTxt2.getText());
				double price = mrp*quantity*(1-discount);
				
				ProductsInBillService service = new ProductsInBillServiceImpl();
		        int quantityAvailable = service.getProductQuantityAvailable(name);

		        if (quantity > quantityAvailable) {
		        	JOptionPane.showMessageDialog(null, "OUT OF STOCK!");
		            System.err.println("Error: Not enough quantity available for product: " + name);
		        } else {
		            ProductsInBill p = new ProductsInBill();
		            p.setId(id);
		            p.setName(name);
		            p.setQuantity(quantity);
		            p.setPrice(price);
		            p.setMrp(mrp);

		            service.addProduct(p);
		            service.updateProductQuantity(name, quantity); // Update the product quantity

		            displayDataProductsInBill();
		            internalFrame.setVisible(false);
		            internalFrame.setVisible(true);
		            productQuantityTxt2.setText("");
		            // billNoTxt.setText("");
		            double total = calcTotal();
		            totalBillAmtTxt.setText(String.valueOf(total));
		        }
		    }
		});
		btnNewButton.setBounds(43, 227, 96, 32);
		internalFrame.getContentPane().add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select any row...");
					return;
				}
				
				int srow = table.getSelectedRow();
				String pname =(String) table.getModel().getValueAt(srow, 1);
				
				ProductsInBillService service = new ProductsInBillServiceImpl();
				service.deleteProduct(pname);
				
				JOptionPane.showMessageDialog(null, "Deletion success! 👍");
				
				displayDataProductsInBill();
				double total = calcTotal();
				totalBillAmtTxt.setText(String.valueOf(total));
				
			}
		});
		btnRemove.setBounds(163, 227, 100, 32);
		internalFrame.getContentPane().add(btnRemove);
		
		billNoTxt = new JTextField();
		billNoTxt.setBounds(139, 48, 96, 19);
		internalFrame.getContentPane().add(billNoTxt);
		billNoTxt.setColumns(10);
		String billNo = generateUniqueBillNumber();
        billNoTxt.setText(billNo);
		
		
		customerNameTxt = new JTextField();
		customerNameTxt.setColumns(10);
		customerNameTxt.setBounds(139, 295, 124, 19);
		internalFrame.getContentPane().add(customerNameTxt);
		
		
		
		productQuantityTxt2 = new JTextField();
		productQuantityTxt2.setColumns(10);
		productQuantityTxt2.setBounds(139, 147, 124, 19);
		internalFrame.getContentPane().add(productQuantityTxt2);
		
		productDiscountTxt2 = new JTextField();
		productDiscountTxt2.setColumns(10);
		productDiscountTxt2.setBounds(139, 170, 124, 19);
		internalFrame.getContentPane().add(productDiscountTxt2);
		
		JLabel lblNewLabel_5 = new JLabel("Date");
		lblNewLabel_5.setBounds(331, 35, 45, 13);
		internalFrame.getContentPane().add(lblNewLabel_5);
		
		dateTxt = new JTextField();
		dateTxt.setColumns(10);
		dateTxt.setBounds(386, 32, 124, 19);
		internalFrame.getContentPane().add(dateTxt);
		dateTxt.setText(LocalDate.now().toString());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(331, 63, 250, 196);
		internalFrame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String[]{
					"Quantity", "Name", "MRP", "Price"
				}
				));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_6 = new JLabel("Total");
		lblNewLabel_6.setBounds(410, 272, 45, 13);
		internalFrame.getContentPane().add(lblNewLabel_6);
		
		totalBillAmtTxt = new JTextField();
		totalBillAmtTxt.setBounds(465, 269, 116, 19);
		internalFrame.getContentPane().add(totalBillAmtTxt);
		totalBillAmtTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int billNo = Integer.parseInt(billNoTxt.getText());
					String customerName = customerNameTxt.getText();
					Double amount = Double.parseDouble(totalBillAmtTxt.getText());
					LocalDate date = LocalDate.parse(dateTxt.getText());
					String name = new LoginFormCashier().getCashierName();
					System.out.println(name);
					
					BillService service = new BillServiceImpl();
					Bill b = new Bill();
					b.setBillNo(billNo);
					b.setCustomerName(customerName);
					b.setAmount(amount);
					b.setDate(date);
					
					service.addBill(b);
					JOptionPane.showMessageDialog(null, "Bill added successfully!");
					
					ReceiptPrinter printer = new ReceiptPrinter(table, customerName, billNo, amount, name);
			        printer.printReceipt();
//					table.print();
					dispose();
					ProductsInBillService pservice = new ProductsInBillServiceImpl();
					pservice.removeAllProductsInBill();
					new MainMenu().setVisible(true);
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(485, 298, 96, 34);
		internalFrame.getContentPane().add(btnNewButton_1);
		
		
		
		ProductService service = new ProductServiceImpl();
	    List<Product> productList = service.getAllProducts();
	    for (Product product : productList) {
	        productNameTxt2.addItem(product.getName());
	    }
	    
	    productMrpTxt2 = new JTextField();
		productMrpTxt2.setColumns(10);
		productMrpTxt2.setBounds(139, 124, 124, 19);
		internalFrame.getContentPane().add(productMrpTxt2);
		productNameTxt2.addActionListener(e -> {
		    String selectedProductName = (String) productNameTxt2.getSelectedItem();
		    for (Product product : productList) {
		        if (product.getName().equals(selectedProductName)) {
		            productMrpTxt2.setText(String.valueOf(product.getMrp()));
		            break;
		        }
		    }
		});
		
		JLabel lblNewLabel_9 = new JLabel("Choose an option....");
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(285, 218, 254, 35);
		contentPane.add(lblNewLabel_9);
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
	
	private void displayDataProductsInBill() {
		ProductsInBillService service  = new ProductsInBillServiceImpl();
		List<ProductsInBill> plist = service.getAllProducts();
		double totalBillAmt = 0;
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0); // reset table
		
		for(ProductsInBill p:plist) {
			tmodel.addRow(new Object[] {p.getQuantity(), p.getName(), p.getMrp(), p.getPrice()});
			totalBillAmt = totalBillAmt + p.getPrice();
		}
		
		
	}
	
	private double calcTotal() {
		ProductsInBillService service  = new ProductsInBillServiceImpl();
		List<ProductsInBill> plist = service.getAllProducts();
		double totalBillAmt = 0;
		
		for(ProductsInBill p:plist) {
			totalBillAmt = totalBillAmt + p.getPrice();
		}
		return totalBillAmt;
		
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
