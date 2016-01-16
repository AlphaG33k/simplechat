package com.javachopshop.chat.message.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javachopshop.chat.message.model.Message;

@RestController
public class MessageController {
	
	private List<Message> messages = new ArrayList<Message>();

	@RequestMapping(value="/message", method=RequestMethod.GET, headers = "Accept=application/json")
	public List<Message> getMessage(){
		return messages;
	}
	
	@RequestMapping(value="/message", produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public void putMessage(@RequestBody final Message message){
		message.setTimestamp(new Date());
		messages.add(message);
		if(messages.size() > 25){
			messages.remove(0);
		}
	}
}
