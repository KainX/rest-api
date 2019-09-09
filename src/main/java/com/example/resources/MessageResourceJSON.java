package com.example.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.example.models.Link;
import com.example.models.Message;
import com.example.services.MessageService;

@Path("messages/json")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResourceJSON {
	
	private static final MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@BeanParam MessageParamBean param, @Context UriInfo uriInfo) {
		if(param.getYear() > 0)
			return messageService.getAllMessagesByYear(param.getYear());
		if((param.getStart() >= 0) && (param.getSize() > 0))
			return messageService.getAllMessagesPaginated(param.getStart(), param.getSize());
		else {
			String uri = uriInfo.getAbsolutePathBuilder().build().toString();
			List<Message> messages = messageService.getAllMessages();
			messages.stream().forEach(e -> {
				e.getLinks().add(new Link(uri + String.valueOf(e.getId()), "self"));
			});
			return messages;
		}			
	}
	
	/**
	 * Get the specified message
	 * @param id message id
	 * @return a Message specified in the id parameter
	 */
	@GET
	@Path("{messageId}")
	public Message getMessage(@PathParam("messageId")long id, @Context UriInfo uriInfo) {
		Message message = messageService.getMessage(id);
		String uri = uriInfo.getAbsolutePathBuilder().build().toString();
		message.getLinks().add(new Link(uri, "self"));
		return message;
	}
	
	/**
	 * Adds a new message
	 * @param message a message in json format using an rest client
	 * @return the added message
	 */
	@POST	
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message entity = messageService.addMessage(message);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(entity.getId())).build();		
		//Returns the http response 201 Created and the location in the header
		return Response.created(uri).entity(entity).build(); 
	}
	
	/**
	 * Update an existing Message resource
	 * @return the updated Message
	 */
	@PUT
	@Path("{id}")
	public Message updateMessage(@PathParam("id")long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("{id}")
	public void removeMessage(@PathParam("id")long id) {
		messageService.removeMessage(id);
	}
	
	/**
	 * Returns an instance of CoomentResource to handle comment subresource http requests
	 * @return an instance of CoomentResource
	 */
	@Path("{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();		
	}
}