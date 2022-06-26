//package com.zensar.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import com.zensar.bean.Category;
//import com.zensar.service.CategoryService;
//
//@RestController
//public class CategoryRestController {
//	
//	@Autowired
//	CategoryService service;
//	
//	@PostMapping("category/add")
//	public Category f1(@RequestBody Category category) {
//		return this.service.addCategory(category);
//	}
//	
//	
//	public Category f2(@RequestBody Category category, @PathVariable (name="id") String id) {
//		return this.service.findByCategoryId(id);
//	}
//
//}
