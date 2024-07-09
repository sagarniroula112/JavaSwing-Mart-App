package com.service;

import java.sql.Connection;
import com.model.*;
import com.service.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.model.ProductsInBill;

public class ProductsInBillServiceImpl implements ProductsInBillService {

	@Override
	public void addProduct(ProductsInBill p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			String sql = "insert into productsinbill (quantity, name, mrp, price) values('" + p.getQuantity() + "', '" + p.getName() + "', '" + p.getMrp() + "', '" + p.getPrice() + "')";
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Product <" + p.getName() +"> successfully added!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "delete from productsinbill where name = '"+ name +"'";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			stm.execute(sql);
			System.out.println("Deletion success!!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductsInBill> getAllProducts() {
		List<ProductsInBill> plist = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sql = "select * from productsinbill";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				// row mapping to object
				ProductsInBill pd = new ProductsInBill();
				
				pd.setId(rs.getInt("id"));
				pd.setName(rs.getString("name"));
				pd.setQuantity(rs.getInt("quantity"));
				pd.setPrice(rs.getInt("price"));
				pd.setMrp(rs.getDouble("mrp"));
				
				plist.add(pd);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		return plist;
	}
	
	@Override
	public void removeAllProductsInBill() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
	        String sql = "DELETE FROM productsinbill";
	        Statement stm = con.createStatement();
	        int rowsAffected = stm.executeUpdate(sql);
	        System.out.println("All products removed successfully! Rows affected: " + rowsAffected);
	        stm.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
    public void updateProductQuantity(String name, int quantity) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
            String sql = "UPDATE product SET quantityAvailable = quantityAvailable - ? WHERE name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, quantity);
            pst.setString(2, name);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public int getProductQuantityAvailable(String name) {
	    int quantityAvailable = 0;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "hello");
	        String sql = "SELECT quantityAvailable FROM product WHERE name = ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, name);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            quantityAvailable = rs.getInt("quantityAvailable");
	        }
	        rs.close();
	        pst.close();
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return quantityAvailable;
	}



}
