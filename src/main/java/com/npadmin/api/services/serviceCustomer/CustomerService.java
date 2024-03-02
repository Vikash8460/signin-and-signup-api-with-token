package com.npadmin.api.services.serviceCustomer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npadmin.api.models.modelCustomer.Customer;
import com.npadmin.api.repositors.repositorCustomer.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private static CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer fetchCustomerByEmail(String email) {

		return customerRepository.findByEmail(email);
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	public Customer updatedCustomer(int id, Customer updatedCustomer) {
		Customer existingCustomer = getCustomerById(id);
		if (existingCustomer == null) {
			// If the User with the given id doesn't exist, return null or throw an
			// exception
			return null;
		}
		// Update the fields of the existing admin with the fields from the updatedAdmin
		// object
		// existingCustomer.setId(updatedCustomer.getId());
		existingCustomer.setFirstname(updatedCustomer.getFirstname());
		existingCustomer.setLastname(updatedCustomer.getLastname());
		existingCustomer.setEmail(updatedCustomer.getEmail());
		existingCustomer.setCity(updatedCustomer.getCity());
		existingCustomer.setPassword(updatedCustomer.getPassword());
		existingCustomer.setConfirmpassword(updatedCustomer.getConfirmpassword());
		existingCustomer.setState(updatedCustomer.getState());
		existingCustomer.setPincode(updatedCustomer.getPincode());
		existingCustomer.setText(updatedCustomer.getText());
		existingCustomer.setDate(updatedCustomer.getDate());
		// Save the updated admin
		return customerRepository.save(existingCustomer);
	}

	private Customer getCustomerById(int id) {
		return customerRepository.findById(id).orElse(null);
	}

	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);

	}

}
