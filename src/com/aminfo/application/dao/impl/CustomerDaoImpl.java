package com.aminfo.application.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aminfo.application.dao.CustomerDao;
import com.aminfo.application.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session sessionManager = sessionFactory.getCurrentSession();
		// create Query
		Query theQuery = sessionManager.createQuery("select c from Customer c order by firstName", Customer.class);
		//  execute query and get result list
		List<Customer> customers = theQuery.getResultList();		
		// return the record
		return customers;
	}

	@Override
	public Customer getCustomer(Integer id) {
		Session sessionManager = sessionFactory.getCurrentSession();
		
//		Query theQuery = sessionManager.createQuery("select c from Customer c where c.id="+id);
		Customer c = sessionManager.get(Customer.class,id);
		return c;
	}

	@Override
	public Customer editCustomerDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save the customer in db
		session.saveOrUpdate(customer);
		return customer;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer c = session.get(Customer.class,id);
		session.delete(c);
		return c;
	}

}
