package com.aminfo.application.service;

import java.util.List;

import com.aminfo.application.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void addCustomer(Customer customer);

	public Customer getCustomer(Integer id);
	
	public Customer deleteCustomer(Integer id);
}
