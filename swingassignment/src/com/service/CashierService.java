package com.service;

import java.util.List;

import com.model.Cashier;

public interface CashierService {
	void addCashier(Cashier c);
	void deleteCashier(int id);
	void updateCashier(Cashier c);
//	List<Product> searchCashier(String searchData);
	List<Cashier> getAllCashiers();
}
