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
	
	static {
		messages.put(1L, new Message(1L, "Hola mundo!", "Juan Pérez"));
		messages.put(2L, new Message(2L, "Hello world!", "Jon Doe"));
	}

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}
	
}
