package com.aminfo.application.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aminfo.application.dao.CustomerDao;
import com.aminfo.application.model.Customer;
import com.aminfo.application.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public void addCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(Integer id) {
		return customerDao.getCustomer(id);
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		return customerDao.deleteCustomer(id);
	}
	
	

}
