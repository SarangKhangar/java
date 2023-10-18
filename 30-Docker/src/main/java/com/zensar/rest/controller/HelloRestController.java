package com.zensar.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	
	@GetMapping("/welcome")
	public String hello() {
		return "Hello Sarang.... from docker";
	}

}
