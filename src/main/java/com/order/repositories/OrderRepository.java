package com.order.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.Customer;
import com.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {


	List<Order> findByCustomerId(long customerId);


}
