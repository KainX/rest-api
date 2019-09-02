package com.example.services;

import java.util.ArrayList;
import java.util.List;

import com.example.database.DataBase;
import com.example.models.Comment;

public class CommentService {
	
	public List<Comment> getAllComments(long messageId){
		List<Comment> comments = new ArrayList<Comment>(DataBase.getAllComments(messageId).values());
		return comments;
	}

	public Comment getComment(long messageId, long commentId) {
		return DataBase.getComment(messageId, commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		return DataBase.addComment(messageId, comment);
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		return DataBase.updateComment(messageId, comment);
	}
	
	public void removeComment(long messageId, long commentId) {
		DataBase.removeComment(messageId, commentId);
	}
}
