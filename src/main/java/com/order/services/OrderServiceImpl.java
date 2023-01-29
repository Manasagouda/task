package com.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.order.entities.Customer;
import com.order.entities.Order;
import com.order.repositories.CustomerRepository;
import com.order.repositories.OrderRepository;
import com.order.util.EmailUtil;

@Service
public class OrderServiceImpl implements OrderService {
	
	
    private  OrderRepository orderRepository;
    private CustomerRepository customerRepo;
    private EmailUtil emailUtil;
	public OrderServiceImpl(OrderRepository orderRepository,CustomerRepository customerRepo,EmailUtil emailUtil) {
		
		this.orderRepository = orderRepository;
		this.customerRepo=customerRepo;
		this.emailUtil=emailUtil;
	}

	@Override
	public Order saveOrder(long customerId, Order order) {
		Customer customer = customerRepo.findById(customerId).get();
		order.setCustomer(customer);
		Order order1 = orderRepository.save(order);
		 emailUtil.sendOrderConfirmationEmail(customer,order);
		return order1;
	}


	@Override
	public List<Order> getOrderByCustomerId(long customerId) {
		List<Order> orders = orderRepository.findByCustomerId(customerId);
		return orders;
	}

	

}
