package com.aminfo.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aminfo.application.model.Customer;
import com.aminfo.application.service.CustomerService;

@Controller()
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	//@RequestMapping("/customerList")
	@GetMapping("/customerList")
	public String getCustomerList(Model model) {
		// get customer from service
		List<Customer> customers = customerService.getCustomers();
		
		// add those customer to the model
		model.addAttribute("customers", customers);
		
		return "customers-list";
	}
	
	@GetMapping("/showAddCustomerForm")
	public String showAddCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.addCustomer(customer);
		return "redirect:/customer/customerList";
	}

	@GetMapping("/showUpdateCustomerForm")
	public String showUpdateCustomerForm(@RequestParam("customerId") Integer id, Model model) {
		
		// get the customer from the database
		Customer customer = customerService.getCustomer(id);
		
		// add customer to model
		model.addAttribute("customer", customer);
		return "add-customer";
		
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") Integer id) {
		System.out.println("reached----------------------------");
		
		customerService.deleteCustomer(id);
		return "redirect:/customer/customerList";
	}
	
}
