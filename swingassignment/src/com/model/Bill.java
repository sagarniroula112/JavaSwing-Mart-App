package com.model;

import java.sql.Date;
import java.time.LocalDate;

public class Bill {
	private int billNo;
	private String customerName;
	private double amount;
	private LocalDate date;
	
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo2) {
		this.billNo = billNo2;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date2) {
		this.date = date2;
	}
}
