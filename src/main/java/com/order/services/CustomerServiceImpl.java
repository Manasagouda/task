package com.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.CustomerDto;
import com.order.entities.Customer;
import com.order.entities.DiscountDetails;
import com.order.entities.Order;
import com.order.repositories.CustomerRepository;
import com.order.repositories.DiscountDetailsRepository;
import com.order.repositories.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepository customerRepo;
	 
	public CustomerServiceImpl(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
		
	}

	@Override
	public Customer findCustomerById(long id) {
		return customerRepo.findById(id).get();
	}

	@Override
	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerRepo.save(customer);
	}

}
