package com.zensar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.bean.Order;
import com.zensar.service.OrderService;

@RestController
public class OrderRestController {
	
	@Autowired
	OrderService service;
	
	@PostMapping("/addorder")
	public Order f1(@RequestBody Order order) {
	return this.service.addOrder(order);
	}



	@GetMapping("/findorder/{Id}")
	public Order f2(@PathVariable(name = "Id") String Id) {
	return this.service.viewOrderByUserId(Id);
	}



	@PutMapping("/updateorder/{Id}")
	public Order f3(@RequestBody Order order, @PathVariable(name = "Id") String Id) {
	return this.service.updateOrderById(order, Id);
	}



	@DeleteMapping("/deleteorder/{id}")
	public boolean f4(@PathVariable(name = "id") String id) {
	return service.removeOrderById(id);
	}



	@GetMapping("/getallorder")
	public List<Order> f5() {
	return this.service.getAllOrders();
	}
}


