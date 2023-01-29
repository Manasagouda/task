package com.order.dto;

import java.util.List;

import com.order.entities.Order;

public class CustomerDto {
	
	private long id;
	
	   public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	private List<Order> orders;
	    private String status;
	    private int orderCount;
	    private String email;
	    private String name;
	    private double discount;
	    
	    public CustomerDto(){
	    	
	    }

		public CustomerDto(List<Order> orders, String status, int orderCount, String email, String name,double discount) {
			
			this.orders = orders;
			this.status = status;
			this.orderCount = orderCount;
			this.email = email;
			this.name = name;
			this.setDiscount(discount);
		}
		public List<Order> getOrders() {
			return orders;
		}
		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getOrderCount() {
			return orderCount;
		}
		public void setOrderCount(int orderCount) {
			this.orderCount = orderCount;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getDiscount() {
			return discount;
		}
		public void setDiscount(double discount) {
			this.discount = discount;
		}


}
