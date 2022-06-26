package com.zensar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.bean.AdvertiesmentStatus;
import com.zensar.service.AdvertiesmentStatusService;

@RestController
public class AdvertiesmentStatusController {

	@Autowired
	AdvertiesmentStatusService advstatusservice;

	@PostMapping(value = "/status/add")
	public AdvertiesmentStatus f1(@RequestBody AdvertiesmentStatus advStatus) {
		return this.advstatusservice.addAdvertiesmentStatus(advStatus);
	}

	@GetMapping(value = "/adverties/status")
	public List<AdvertiesmentStatus> f2() {
		return this.advstatusservice.getAllAdvertiesmentStatus();
	}

}
