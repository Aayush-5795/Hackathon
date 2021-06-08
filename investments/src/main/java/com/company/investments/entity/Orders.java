package com.company.investments.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	
	private String stockCode;
	
	private String stockName;
	
	private long quantity;
	
	private double price;
	
	private LocalTime orderDate;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private UserAccounts userAccount;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalTime orderDate) {
		this.orderDate = orderDate;
	}

	public UserAccounts getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccounts userAccount) {
		this.userAccount = userAccount;
	}
	


}
