package com.zensar.bean;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {

	@Id
	private String orderId;
	private LocalDate orderDate;
	private String orderStatus;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "customerId")
	private Customer customer;
	@ElementCollection
	@CollectionTable(name = "order_product_mapping", joinColumns = {
	@JoinColumn(name = "orderId", referencedColumnName = "orderId") })
	@MapKeyColumn(name = "product_name")
	@Column(name = "quantity")
	private Map<Product, String> productList;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;

	public Order(String orderId, LocalDate orderDate, String orderStatus, Customer customer, Map productList,
			Address address) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.customer = customer;
		this.productList = productList;
		this.address = address;
	}

	public Order() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map getProductList() {
		return productList;
	}

	public void setProductList(Map productList) {
		this.productList = productList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", customer="
				+ customer + ", productList=" + productList + ", address=" + address + "]";
	}

}
