package com.aminfo.application.dao;

import java.util.List;

import com.aminfo.application.model.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();
	public Customer getCustomer(Integer id);
	public Customer saveCustomer(Customer customer);
	public Customer editCustomerDetails();
	public Customer deleteCustomer(Integer id);
}
