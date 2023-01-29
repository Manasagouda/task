package com.order.services;

import java.util.List;

import com.order.entities.Customer;
import com.order.entities.DiscountDetails;

public interface DiscountService {

	DiscountDetails getDiscount(Customer customer, DiscountDetails discountDetails);

	List<DiscountDetails> getDiscountDetailsByCustomerId(long customerId);

}
