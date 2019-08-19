package com.example.database;

import java.util.HashMap;
import java.util.Map;

import com.example.models.Message;
import com.example.models.Profile;

/**
 * Database simulation
 * @author Kain
 *
 */
public class DataBase {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static long messageId = 0;
	private static long profileId = 0;
	
	static {
		messages.put(++messageId, new Message(messageId, "Hola mundo!", "Juan Pérez"));
		messages.put(++messageId, new Message(messageId, "Hello world!", "Jon Doe"));
		profiles.put("JuanPerez", new Profile(++profileId, "JuanPerez", "Juan", "Pérez"));
		profiles.put("JonDoe", new Profile(++profileId, "JonDoe", "Jon", "Doe"));		
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
			message.setId(++messageId);
			messages.put(messageId, message);
			return messages.get(messageId);
		}
		return null;
	}
	
	public static Message updateMessage(Message message) {
		if(message != null) {
			long currentId = message.getId();
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
	
	public static Map<String, Profile> getAllProfiles(){
		return profiles;
	}
	
	public static Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public static Profile addProfile(Profile profile) {
		if(profile != null) {
			profile.setId(++profileId);
			profiles.put(profile.getProfileName(), profile);
			return profiles.get(profile.getProfileName());
		}
		return null;
	}
	
	public static Profile updateProfile(Profile profile) {
		if(profile != null) {			
			String profileName = profile.getProfileName();
			long currentId = profiles.get(profileName).getId();
			profile.setId(currentId);
			profiles.put(profileName, profile);			
			return profiles.get(profileName);
		}
		return null;
	}
	
	public static void removeProfile(String profileName) {
		if(!profileName.isEmpty()) {
			profiles.remove(profileName);
		}
	}
}
