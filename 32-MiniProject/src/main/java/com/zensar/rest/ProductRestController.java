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
import com.zensar.bean.Product;
import com.zensar.service.ProductService;

@RestController
public class ProductRestController {
	
	@Autowired
	ProductService service;

	@PostMapping("/addproduct")
	public Product f1(@RequestBody Product product) {
	return this.service.addProduct(product);
	}



	@GetMapping("/findproduct/{Id}")
	public Product f2(@PathVariable(name = "Id") String Id) {
	return this.service.viewByProductId(Id);
	}



	@PutMapping("/updateproduct/{Id}")
	public Product f3(@RequestBody Product product, @PathVariable(name = "Id") String Id) {
	return this.service.updateProductById(product, Id);
	}



	@DeleteMapping("/deleteproduct/{id}")
	public boolean f4(@PathVariable(name = "id") String id) {
	return service.removeProduct(id);
	}



	@GetMapping("/getallproduct")
	public List<Product> f5() {
	return this.service.viewAllProducts();
	}
}


