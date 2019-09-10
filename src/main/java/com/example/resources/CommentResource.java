package com.example.resources;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.Comment;
import com.example.services.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private static final CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long id){
		return commentService.getAllComments(id);
	}
	
	@GET
	@Path("{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	public Comment updateComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("{commentId}")
	public void removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
}
