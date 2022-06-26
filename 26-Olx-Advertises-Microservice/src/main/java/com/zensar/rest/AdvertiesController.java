package com.zensar.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.bean.Adverties;
import com.zensar.service.AdvertiesService;

@RestController
public class AdvertiesController {

	@Autowired
	AdvertiesService service;

	// To add new advertises
	@PostMapping("/advertise")
	public Adverties newAdvertise(@RequestBody Adverties advertise) {
		return service.addAdveries(advertise);
	}

	// To update existing advertise
	@PutMapping("/advertise/{id}")
	public Adverties updateAdvertise(@RequestBody Adverties ad, @PathVariable Integer id) {
		return service.updateAdverties(ad, id);
	}

	// To read all the advertise posted by logged in user
	@GetMapping("/user/advertise")
	public List<Adverties> getAllAdvertises() {
		return service.getAllAdverties();
	}

	// Deletes specific advertisement posted by logged in user
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteAdvertiseById(@PathVariable("id") Integer id) {
		return service.deleteAdvertiseById(id);
	}

	// Get Advertise by id
	@RequestMapping("/advertise/{postId}")
	public Adverties getAdvertisesById(@PathVariable Integer id) {
		return service.getCategoryId(id);
	}

}
