package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Cashier;

public class CashierServiceImpl implements CashierService {

	@Override
	public void addCashier(Cashier c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "insert into cashier (name, phone, address, email, password) values('" + c.getName() + "', '" + c.getPhone() + "', '" + c.getAddress() + "', '" + c.getEmail() + "', '" + c.getPassword() + "')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Cashier <" + c.getName() +"> successfully added!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCashier(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "delete from cashier where id = '"+ id +"'";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Deletion success!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCashier(Cashier c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "update cashier set name = '"+c.getName()+"', phone = '"+c.getPhone()+"', address = '"+c.getAddress()+"', email = '"+c.getEmail()+"', password = '"+c.getPassword()+"' where id = '"+c.getId()+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Update success!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Cashier> getAllCashiers() {
		List<Cashier> plist = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from cashier";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				Cashier pd = new Cashier();
				
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setPhone(rs.getString("phone"));
				pd.setAddress(rs.getString("address"));
				pd.setEmail(rs.getString("email"));
				pd.setPassword(rs.getString("password"));
				
				plist.add(pd);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	return plist;
	}

}
