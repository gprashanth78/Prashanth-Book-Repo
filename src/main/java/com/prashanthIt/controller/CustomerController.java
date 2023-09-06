package com.prashanthIt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prashanthIt.entity.Customer;
import com.prashanthIt.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/customer/emailCheck/{customerEmail}")
	public ResponseEntity<String> emailCheck(@PathVariable("customerEmail") String customerEmail){
		boolean emailUnique = customerService.isEmailUnique(customerEmail);
		if(emailUnique) {
			return new ResponseEntity<String>("UNIQUE", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Email has already taken", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/customer/addCustomer", consumes = "application/json")
	public ResponseEntity<String> addCustomerDetails(@RequestBody Customer customer) {
		boolean addCustomer = customerService.registerCustomer(customer);
		if (addCustomer) {
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Failed to add Customer details", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/customer/getAllCustomers", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customersList = customerService.retrieveAllCustomers();
		return new ResponseEntity<List<Customer>>(customersList, HttpStatus.OK);
	}

	@GetMapping(value = "/customer/getCustomer/{customerId}", produces = "application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/customer/updateCustomer/{customerId}", consumes = "application/json")
	public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer,
			@PathVariable("customerId") Integer customerId) {
		Customer customerDetails = customerService.getCustomerById(customerId);
		customerDetails.setCustomerFullName(customer.getCustomerFullName());
		customerDetails.setAddress(customer.getAddress());
		customerDetails.setCity(customer.getCity());
		customerDetails.setState(customer.getState());
		customerDetails.setCountry(customer.getCountry());
		customerDetails.setZipCode(customer.getZipCode());
		customerDetails.setRegisteredDate(customer.getRegisteredDate());
		@SuppressWarnings("unused")
		boolean registerCustomer = customerService.registerCustomer(customerDetails);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/customer/deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") Integer customerId) {
		boolean deleteCustomer = customerService.deleteCustomerById(customerId);
		if (deleteCustomer) {
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Failed to delete customer details", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
