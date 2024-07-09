package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Bill;
import com.model.Cashier;
import com.model.Product;

public class BillServiceImpl implements BillService {

	@Override
	public void addBill(Bill b) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "insert into bill (billNo, customerName, amount, date) values('" + b.getBillNo() + "', '" + b.getCustomerName() + "', '" + b.getAmount() + "', '" + b.getDate() + "')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Product <" + b.getBillNo() +"> successfully added!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Bill> searchBills(String searchData) {
		List<Bill> plist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from bill where customerName like '%"+searchData+"%'";
//			String sql = "select * from product where name like '%"+searchData+"%' OR company like '%"+searchData+"%'";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				Bill b = new Bill();
				
				b.setBillNo(rs.getInt("billNo"));
				b.setCustomerName(rs.getString("customerName"));
				b.setAmount(rs.getDouble("amount"));
				b.setDate(LocalDate.now());
				
				plist.add(b);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	return plist;
	}

	@Override
	public List<Bill> getAllBills() {
		List<Bill> plist = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from bill";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				Bill pd = new Bill();
				
				pd.setBillNo(rs.getInt("billNo"));
				pd.setCustomerName(rs.getString("customerName"));
				pd.setAmount(rs.getDouble("amount"));
				java.sql.Date sqlDate = rs.getDate("date");
                
                    LocalDate localDate = sqlDate.toLocalDate();
                    pd.setDate(localDate); // Assuming setDate(LocalDate date)
                
				
				plist.add(pd);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	return plist;
	}

}
