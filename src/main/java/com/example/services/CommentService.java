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

}
