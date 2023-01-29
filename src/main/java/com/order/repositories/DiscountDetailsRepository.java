package com.order.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.DiscountDetails;

public interface DiscountDetailsRepository extends JpaRepository<DiscountDetails, Long> {

	List<DiscountDetails>findByCustomerId(long customerId);

}
