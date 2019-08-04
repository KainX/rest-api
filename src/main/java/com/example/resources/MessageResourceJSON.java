package com.example.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Message;
import com.example.services.MessageService;

@Path("messages/json")
public class MessageResourceJSON {
	
	private static final MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		List<Message> mensajes = new ArrayList<>();
		mensajes = messageService.getAllMessages();
		return mensajes;
	}
	
	/**
	 * Get the specified message
	 * @param id message id
	 * @return a Message specified in the id parameter
	 */
	@GET
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId")long id) {
		return messageService.getMessage(id);
	}
	
	/**
	 * Adds a new Message
	 * @return the added message
	 */
	@GET
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage() {
		Message message = new Message("No message", "Shigeru Miyamoto");
		return messageService.addMessage(message);
	}
	
	/**
	 * Update an existing Message resource
	 * @return the updated Message
	 */
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage() {
		Message message = new Message(2L, "This is a new message", "Hideo Kojima");
		return messageService.updateMessage(message);
	}
}