package com.stepinfo.dao;

import com.stepinfo.dao.beans.Customer;

public interface CustomerDAO {
	
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public int getMaxId();

}
