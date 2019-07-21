package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Message;

public class MessageService {
	
	/**
	 * Simulating a data access to a db
	 * @return a list of messages
	 */
	public List<Message> getMessages(){
		List<Message> messages = new ArrayList<>();
		messages.add(new Message(1L, "Juan Pérez"));
		messages.add(new Message(2L, "Lily Sánchez"));
		messages.add(new Message(3L, "Pepe Hernández"));
		return messages;
	}

}
