package com.example.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Message;
import com.example.services.MessageService;

@Path("messages/json")
public class MessageResourceJSON {
	 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		MessageService messageService = new MessageService();
		List<Message> mensajes = new ArrayList<>();
		mensajes = messageService.getMessages();
		return mensajes;
	}
}