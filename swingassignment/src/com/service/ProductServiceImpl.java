package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {

	@Override
	public void addProduct(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "insert into product (name, quantityAvailable, mrp) values('" + p.getName() + "', '" + p.getQuantityAvailable() + "', '" + p.getMrp() + "')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Product <" + p.getName() +"> successfully added!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "delete from product where id = '"+ id +"'";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Deletion success!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "update product set name = '"+p.getName()+"', quantityAvailable = '"+p.getQuantityAvailable()+"', mrp = '"+p.getMrp()+"' where id = '"+p.getId()+"'";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Addition success!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> searchProduct(String searchData) {
		List<Product> plist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from product where name like '%"+searchData+"%'";
//			String sql = "select * from product where name like '%"+searchData+"%' OR company like '%"+searchData+"%'";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				Product pd = new Product();
				
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setQuantityAvailable(rs.getInt("quantityAvailable"));
				pd.setMrp(rs.getDouble("mrp"));
				
				plist.add(pd);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	return plist;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> plist = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from product";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				Product pd = new Product();
				
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setQuantityAvailable(rs.getInt("quantityAvailable"));
				pd.setMrp(rs.getDouble("mrp"));
				
				plist.add(pd);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	return plist;
	}
}
