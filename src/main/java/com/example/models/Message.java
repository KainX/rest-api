package com.example.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.json.bind.annotation.JsonbTransient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private String author;
	private Date created;
	private Map<Long, Comment> comments = new HashMap<>();
	
	/**
	 * No argument constructor is needed for the xml and json converter
	 */
	public Message() {}
	/*
	public Message(long id, String message, String author, Map<Long, Comment> comments) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.comments = comments;
		this.created = new Date();
	}
	*/
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public Message(String message, String author) {
		this.message = message;
		this.author = author;
		this.created = new Date();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@XmlTransient
	@JsonbTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	@XmlTransient
	@JsonbTransient
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

}
