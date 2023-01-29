package com.order.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
