package com.order.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.order.entities.Customer;
import com.order.entities.DiscountDetails;
import com.order.entities.Order;
import com.order.repositories.CustomerRepository;
import com.order.repositories.DiscountDetailsRepository;
import com.order.repositories.OrderRepository;
@Service
public class DiscountServiceImpl implements DiscountService {
	
	private DiscountDetailsRepository discountRepo;
	private CustomerRepository customerRepo;
	private OrderRepository orderRepo;

	public DiscountServiceImpl(DiscountDetailsRepository discountRepo, CustomerRepository customerRepo
			,OrderRepository orderRepo) {
		
		this.discountRepo = discountRepo;
		this.customerRepo = customerRepo;
		this.orderRepo=orderRepo;
	}

	@Override
	public DiscountDetails getDiscount(Customer customer, DiscountDetails discountDetails) {
		int orderCount=0;
		 String status="regular";
		orderCount=findNoOfOrders(customer.getOrders());
		customer.setOrderCount(orderCount);
		  status=checkStatus(orderCount);
		  customer.setStatus(status);
		 double discount =calculateDiscount(customer.getStatus());
		 discountDetails .setDiscount(discount);
		 if(orderCount>10) {
		 DiscountDetails details = discountRepo.save(discountDetails)  ;
		return details;
		 }
		 else {
			 return null;
		 }
	}
	private String checkStatus(int orderCount1) {
		if(orderCount1>=10) {
			return "gold";
		}else if(orderCount1>=20){
			return "platinum";
		}
		return "regular";
	}

	private double calculateDiscount(String status) {
		if (status.equals("gold") ) {
		      return 0.1;
		    } else if (status.equals("platinum")) {
		      return 0.2;
		    } else {
		      return 0;
		    }   }

	private int findNoOfOrders(List<Order> orders) {
		List<Order> findAll = orderRepo.findAll();
		int ordercount = findAll.size();
		return ordercount;
	}

	@Override
	public List<DiscountDetails> getDiscountDetailsByCustomerId(long customerId) {
		List<DiscountDetails> customers = discountRepo.findByCustomerId(customerId);
		return customers;
	}

}
