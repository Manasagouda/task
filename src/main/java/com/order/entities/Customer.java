package com.order.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
   private List<Order> orders;
    
    @Column(name = "order_count", nullable = false)
    private int orderCount;

    @Column(name = "status", nullable = false)
    private String status;
    

public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


    public Customer(String name, String email, List<Order> orders,int orderCount,String status) {
		super();
		this.name = name;
		this.email = email;
		this.orders = orders;
		this.status = status;
		this.orderCount = orderCount;

	}

	public Customer() {}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

}

 