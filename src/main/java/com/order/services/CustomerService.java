package com.order.services;

import java.util.List;

import com.order.dto.CustomerDto;
import com.order.entities.Customer;
import com.order.entities.DiscountDetails;
import com.order.entities.Order;

public interface CustomerService {

	Customer findCustomerById(long id);

	List<Customer> findAll();

	Customer saveCustomer(Customer customer);
	

}
