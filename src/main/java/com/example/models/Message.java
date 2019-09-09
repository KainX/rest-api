package com.example.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	private List<Link> links = new ArrayList<>();
	
	/**
	 * No argument constructor is needed for the xml and json converter
	 */
	public Message() {}
	
	public Message(long id, String message, String author, Map<Long, Comment> comments) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.comments = comments;
		this.created = new Date();
	}
	
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
	
	/**
	 * Annotations in this method make comments unavailable for xml and json conversion
	 * @return
	 */
	@XmlTransient
	@JsonbTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

}
