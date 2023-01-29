package com.order.services;

import java.util.List;
import java.util.Map;

import com.order.entities.Customer;
import com.order.entities.Order;

public interface OrderService {


	Order saveOrder(long customerId, Order order);

	List<Order>getOrderByCustomerId(long customerId);


}
