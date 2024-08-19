package com.service;

import java.util.List;

import com.model.Bill;
import com.model.Cashier;

public interface BillService {
	// comment
	void addBill(Bill b);
//	void deleteBill(int id);
//	void updateCashier(Cashier c);
	List<Bill> searchBills(String searchData);
	List<Bill> getAllBills();
}
