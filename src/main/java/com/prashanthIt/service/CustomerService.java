package com.prashanthIt.service;

import java.util.List;

import com.prashanthIt.entity.Customer;

public interface CustomerService {

	public boolean registerCustomer(Customer customer);

	public List<Customer> retrieveAllCustomers();

	public Customer getCustomerById(Integer customerId);

	public boolean deleteCustomerById(Integer customerId);
	
	public boolean isEmailUnique(String customerEmail);
}
