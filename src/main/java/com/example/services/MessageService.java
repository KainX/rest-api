package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.database.DataBase;
import com.example.models.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DataBase.getAllMessages();
	
	/**
	 * Simulating a data access to a db
	 * @return a list of messages
	 */
	public List<Message> getAllMessages(){		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		
		return null;
	}
	
	public Message addMessage(Message message) {
		return null;
	}
	
	public Message updateMessage(Message message) {
		return null;
	}
	
	public Message removeMessage(long id) {
		return null;
	}
}
