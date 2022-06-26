package com.zensar.displayservice.srvice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zensar.displayservice.feign.client.MessageFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DisplayServiceImpl {
	
	@Autowired
	private MessageFeignClient fiegnClient;
	
	@CircuitBreaker(name= "messageservice", fallbackMethod = "handleFailure")
	public String printMessage() {
		return fiegnClient.callGenerateMessage();
	}
	
	//Following is a fallback method 
	//This is automatically executed when the server is down (when circuit is open)
	public String handleFailure(Throwable t) {
		return "This is default message messagemicrosevice is not running.... please try again....";
	}
	

}
