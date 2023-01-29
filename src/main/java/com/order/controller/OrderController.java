package com.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entities.Customer;
import com.order.entities.DiscountDetails;
import com.order.entities.Order;
import com.order.repositories.CustomerRepository;
import com.order.repositories.OrderRepository;
import com.order.services.CustomerService;
import com.order.services.DiscountService;
import com.order.services.OrderService;
import com.order.util.EmailUtil;

@RestController
@RequestMapping("/api")
public class OrderController {
		
	private OrderService orderService;
	private DiscountService discountService;


	public OrderController(OrderService orderService,DiscountService discountService) {
		this.discountService = discountService;

		this.orderService = orderService;
	}

	@GetMapping("/customers/{customerId}/orders")
	public List<Order> findAllOrdersByCustomer(@PathVariable("customerId") long customerId){
		 List<Order> orders=orderService.getOrderByCustomerId(customerId);
		 return orders;
	}
	@PostMapping("/customers/{customerId}/orders")
    public Order saveOrder(@PathVariable long customerId, @RequestBody Order order,@RequestBody DiscountDetails discountDetails) {
		Order order1 = orderService.saveOrder(customerId,order);
		return order1;
    
    }

	
	
}
