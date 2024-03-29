package com.vmware.orderservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "onlineorder")
public class OnlineOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "product_id")
    private Long productId;
    
    private int quantity;
    // getters and setters
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getUserId() {
    	return userId;
    }
    
    public void setUserId(Long userId) {
    	this.userId = userId;
    }
    
    public Long getProductId() {
    	return productId;
    }
    
    public void setProductId(Long productId) {
    	this.productId = productId;
    }
    
    public int getQuantity() {
    	return quantity;
    }
    
    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }
    
    @Override
    public String toString() {
    	return "Order{" +
    			"userId= "+userId+
    			", productId= " + productId + 
    			", quantity= "+quantity+
    			"}";
    }
    
    public OnlineOrder() {
    	
    }
    
    public OnlineOrder(Long userId, Long productId, int quantity) {
    	this.userId = userId;
    	this.productId = productId;
    	this.quantity = quantity;
    }
}
