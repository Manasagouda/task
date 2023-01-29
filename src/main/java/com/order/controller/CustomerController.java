package com.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.dto.CustomerDto;
import com.order.entities.Customer;
import com.order.entities.DiscountDetails;
import com.order.services.CustomerService;
import com.order.services.DiscountService;
@RestController
@RequestMapping("/api/c1")

public class CustomerController {
	
   
   private CustomerService customerService;
   private DiscountService discountService;
    public CustomerController(CustomerService customerService,DiscountService discountService) {
	this.discountService=discountService;
	this.customerService = customerService;
}
	
    @PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer,@RequestBody DiscountDetails discountDetails){
    	  Customer customer1 = customerService.saveCustomer(customer);
  		discountService.getDiscount(customer,discountDetails);

    	  return customer1;
    }	 

	@GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/customer/id/{id}")
    public Customer findCustomerById(@PathVariable long id) {
		return customerService.findCustomerById(id);
    }
	    
    @GetMapping("/customers/{customerId}/discount")
	public List<DiscountDetails> findAllOrdersByCustomer(@PathVariable("customerId") long customerId){
		 List<DiscountDetails> orders=discountService.getDiscountDetailsByCustomerId(customerId);
		 return orders;
	
	}


		    }

