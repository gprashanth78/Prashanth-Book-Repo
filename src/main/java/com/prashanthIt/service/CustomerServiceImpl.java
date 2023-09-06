package com.prashanthIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prashanthIt.entity.Customer;
import com.prashanthIt.passwordUtils.RandomTextGenerator;
import com.prashanthIt.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository cRepo;

	@Override
	public boolean registerCustomer(Customer customer) {
		customer.setPassword(RandomTextGenerator.passwordGenerator(10));
		Customer add = cRepo.save(customer);
		return add.getCustomerId() != null;
	}

	@Override
	public List<Customer> retrieveAllCustomers() {
		return cRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Integer customerId) {
		Optional<Customer> findById = cRepo.findById(customerId);
		if (findById.isPresent()) {
			Customer customer = findById.get();
			return customer;
		}
		return null;
	}

	@Override
	public boolean deleteCustomerById(Integer customerId) {
		cRepo.deleteById(customerId);
		return true;
	}

	@Override
	public boolean isEmailUnique(String customerEmail) {
		Customer customerDetails = cRepo.getCustomerByEmail(customerEmail);
		if(customerDetails !=null) {
			return false;
		}
		return true;
	}

}
