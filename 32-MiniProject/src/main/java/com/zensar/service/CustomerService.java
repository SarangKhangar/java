package com.zensar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.bean.Category;
import com.zensar.bean.Customer;
import com.zensar.db.CustomerDAO;

@Service
public class CustomerService {

	@Autowired
	CustomerDAO customerdao;

	public Customer addCustomer(Customer customer) {
		return this.customerdao.save(customer);
	}

	public Customer updateCustomerById(Customer customer, String id) {
		Optional<Customer> optional = this.customerdao.findById(id);
        if(optional.isPresent()) {
		return customerdao.save(customer);
        }
        return customer;	
        }

	public boolean removeCustomerById(String id) {
		Optional<Customer> optional = this.customerdao.findById(id);
		if (optional.isPresent()) {
			this.customerdao.deleteById(id);
			return true;
		}
		else {
		return false;}
	}

	public Customer viewCustomer(Customer customer) {
		return this.customerdao.findById(customer.getCustomerId()).get();
	}

	public List<Customer> viewAllCustomer() {
		return this.customerdao.findAll();
	}
}