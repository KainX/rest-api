package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.database.DataBase;
import com.example.models.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DataBase.getAllMessages();
	
	/**
	 * Emulating a data access to a db
	 * @return a list of messages
	 */
	public List<Message> getAllMessages(){		
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {		
		return DataBase.getMessage(id);
	}
	
	public List<Message> getAllMessagesByYear(int year){
		return DataBase.getAllMessagesByYear(year);
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size) {
		return DataBase.getAllMessagesPaginated(start, size);
	}
	
	public Message addMessage(Message message) {		
		return DataBase.addMessage(message);
	}
	
	public Message updateMessage(Message message) {
		return DataBase.updateMessage(message);
	}
	
	public void removeMessage(long id) {
		DataBase.removeMessage(id);
	}
}
