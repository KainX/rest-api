package com.example.database;

import java.util.HashMap;
import java.util.Map;

import com.example.models.Message;

/**
 * Database simulation
 * @author Kain
 *
 */
public class DataBase {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static long id = 0;
	
	static {
		messages.put(++id, new Message(id, "Hola mundo!", "Juan Pérez"));
		messages.put(++id, new Message(id, "Hello world!", "Jon Doe"));
	}

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}
	
	public static Message getMessage(long id) {
		return messages.get(id);
	}
	
	public static Message addMessage(Message message) {
		if(message != null) {
			message = new Message(message.getMessage(), message.getAuthor()); //Points the message reference to a new Message instance
			message.setId(++id);
			messages.put(id, message);
			return messages.get(id);
		}
		return null;
	}
	
	public static Message updateMessage(Message message) {
		if(message != null) {
			long currentId = message.getId();
			//message = new Message(message.getMessage(), message.getAuthor());
			
			messages.put(currentId, message);
			return messages.get(currentId);
		}
		return null;
	}
	
	public static void removeMessage(long id) {
		if(id > 0) {
			messages.remove(id);
		}
	}
}
