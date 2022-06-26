package com.zensar.displayservice.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "messageservice", url="http://localhost:7071/api/message")
public interface MessageFeignClient  {
	
	@GetMapping
	public String callGenerateMessage(); 
		
	

}
