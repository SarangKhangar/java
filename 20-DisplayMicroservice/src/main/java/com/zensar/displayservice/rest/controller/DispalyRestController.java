package com.zensar.displayservice.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.displayservice.feign.client.MessageFeignClient;

@RestController
public class DispalyRestController {
	@Autowired
	private MessageFeignClient fiegnClient;
	
	@GetMapping("/api/display")
	public String printMessage() {
		return fiegnClient.callGenerateMessage();
	}

}
