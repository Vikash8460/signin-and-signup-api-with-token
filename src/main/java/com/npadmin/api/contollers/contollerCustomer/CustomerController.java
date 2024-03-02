package com.npadmin.api.contollers.contollerCustomer;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npadmin.api.models.modelCustomer.Customer;
import com.npadmin.api.services.serviceCustomer.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
	
	@PostMapping("/addCustomer")
	@CrossOrigin(origins = "*")
	public Customer addcustomerer(@RequestBody Customer customer) throws Exception {
		String tempEmail=customer.getEmail();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			Customer customerobj=customerService.fetchCustomerByEmail(tempEmail);
			if(customerobj!=null) {
				System.out.println("Customer Email: " +tempEmail+ " are already exist");
				throw new Exception("Customer "+tempEmail+" are already exist");
			}
		}
		 Customer customerobj=null;
		customerobj= customerService.saveCustomer(customer);
		return customerobj;	
	}
	
	@GetMapping
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<List<Customer>> getAllCustomer() { 
	        List<Customer> customer = customerService.getAllCustomer();
	        return new ResponseEntity<>(customer, HttpStatus.OK);
	    }
	
	 @PutMapping("/{id}")
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
		 Customer customer =  customerService.updatedCustomer(id, updatedCustomer);
	        if (customer != null) {
	            return new ResponseEntity<>(customer, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @DeleteMapping("/{id}")
	 @CrossOrigin(origins = "*")
	    public ResponseEntity<Void> deleteCustomerById(@PathVariable int id) {
		 customerService.deleteCustomerById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
	

}
