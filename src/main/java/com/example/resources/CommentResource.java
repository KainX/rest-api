package com.example.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Comment;
import com.example.services.CommentService;

@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private static final CommentService commentService = new CommentService();
	
	@GET
	/*public List<Comment> getAllComments(@PathParam("{messageId}") long id){
		return commentService.getAllComments(id);
	}*/
	public String getTest() {
		return "lolxd";
	}

}
