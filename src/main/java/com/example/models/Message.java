package com.example.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String author;
	private Date created;
	
	/**
	 * No argument constructor is needed for the xml and json converter
	 */
	public Message() {}
	
	public Message(long id, String author) {
		this.id = id;
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

	
}