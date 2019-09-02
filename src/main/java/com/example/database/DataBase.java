package com.example.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.example.models.Comment;
import com.example.models.Message;
import com.example.models.Profile;

/**
 * Database emulation
 * @author Kain
 *
 */
public class DataBase {
	
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<Long, Comment> comments1 = new HashMap<>();
	private static Map<Long, Comment> comments2 = new HashMap<>();
	private static long messageId = 0;
	private static long profileId = 0;
	private static long commentId = 0;
	
	/**
	 * Hardcoded data for testing
	 */
	static {
		comments1.put(++commentId, new Comment(commentId, "This is just a comment", "Jon Doe"));
		comments2.put(++commentId, new Comment(commentId, "Esto es solo un comentario", "Juan Pérez"));
		messages.put(++messageId, new Message(messageId, "Hola mundo!", "Juan Pérez", comments1));
		messages.put(++messageId, new Message(messageId, "Hello world!", "Jon Doe", comments2));		
		profiles.put("JuanPerez", new Profile(++profileId, "JuanPerez", "Juan", "Pérez"));
		profiles.put("JonDoe", new Profile(++profileId, "JonDoe", "Jon", "Doe"));		
	}

	public static Map<Long, Message> getAllMessages() {
		return messages;
	}
	
	public static Message getMessage(long id) {
		return messages.get(id);
	}
	
	/**
	 * Gets a list of messages by year using a stream.
	 * @param year
	 * @return
	 */
	public static List<Message> getAllMessagesByYear(int year){
		Calendar calendar = Calendar.getInstance();
		List<Message> messagesList = new ArrayList<>();
		Stream<Message> mStream = messages.values().stream();		
		mStream.forEach(e -> {
				calendar.setTime(e.getCreated());
				if(calendar.get(Calendar.YEAR) == year) {
					messagesList.add(e);
				}
			});
		return messagesList;
	}
	
	public static List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> messagesList = new ArrayList<>(messages.values());
		if(start >= messages.size()) {
			return new ArrayList<Message>();
		}
		return messagesList.subList(start, start+size);
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
	
	public static Map<Long, Comment> getAllComments(long id){
		if(id > 0) {
			return messages.get(id).getComments();
		}
		return null;
	}
	
	public static Comment getComment(long messageId, long commentId) {
		if((messageId > 0) && (commentId > 0)) {
			return messages.get(messageId).getComments().get(commentId);
		}
		return null;
	}
	
	public static Comment addComment(long messageId, Comment comment) {
		if(messageId > 0) {
			comment.setId(commentId);
			messages.get(messageId).getComments().put(++commentId, comment);			
			return getComment(messageId, commentId);
		}
		return null;
	}
	
	public static Comment updateComment(long messageId, Comment comment) {
		if((messageId > 0) && (comment != null)) {
			long curCommentId = comment.getId();
			messages.get(messageId).getComments().put(curCommentId, comment);
			return getComment(messageId, curCommentId);
		}
		return null;
	}
	
	public static void removeComment(long messageId, long commentId) {
		if((messageId > 0) && (commentId > 0)) {
			messages.get(messageId).getComments().remove(commentId);
		}
	}
}
