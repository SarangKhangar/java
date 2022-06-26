package com.zensar.messageapi.rest.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zensar.messageapi.entity.Message;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/message")
public class MessageRestController {
	
	private List<Message> messages;
	
	public MessageRestController() {
		this.messages=new ArrayList<>();
		
		Message m1 = new Message();
		m1.setId(1);
		m1.setMessage("good morning");
		
		Message m2 = new Message();
		m2.setId(2);
		m2.setMessage("good evening");
		
		this.messages.add(m1);
		this.messages.add(m2);
	}
	
	@ApiOperation(value="This method is use to fetch all the messages from database")
	@GetMapping
	public List<Message> findAll(){
		return this.messages;
	}
	
	@PostMapping
	public Message addMessage(@RequestBody Message newMessage) {
		 this.messages.add(newMessage);
		 return newMessage;
	}

}
