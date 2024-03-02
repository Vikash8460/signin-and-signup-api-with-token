package com.npadmin.api.repositors.repositorCustomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npadmin.api.models.modelCustomer.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	//public Customer fetchCustomerByEmailId(String email);

	public Customer findByEmail(String email);

	//public Customer save(Customer customer);
}