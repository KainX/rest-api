package com.example.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.models.Message;
import com.example.services.MessageService;

@Path("messages/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourceJSON {
	
	private static final MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start")int start,
									 @QueryParam("size")int size) {
		if(year > 0)
			return messageService.getAllMessagesByYear(year);
		if((start >= 0) && (size > 0))
			return messageService.getAllMessagesPaginated(start, size);
		else 
			return messageService.getAllMessages();
	}
	
	/**
	 * Get the specified message
	 * @param id message id
	 * @return a Message specified in the id parameter
	 */
	@GET
	@Path("{messageId}")
	public Message getMessage(@PathParam("messageId")long id) {
		return messageService.getMessage(id);
	}
	
	/**
	 * Adds a new message
	 * @param message a message in json format using an rest client
	 * @return the added message
	 */
	@POST	
	public Message addMessage(Message message) {
		//Message message = new Message("No message", "Shigeru Miyamoto");		
		return messageService.addMessage(message);
	}
	
	/**
	 * Update an existing Message resource
	 * @return the updated Message
	 */
	@PUT
	@Path("{id}")
	public Message updateMessage(@PathParam("id")long id, Message message) {
		//Message message = new Message(2L, "This is a new message", "Hideo Kojima");
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("{id}")
	public void removeMessage(@PathParam("id")long id) {
		messageService.removeMessage(id);
	}
}