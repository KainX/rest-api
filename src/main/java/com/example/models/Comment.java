package com.example.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for the Comment subresource
 * @author Kain
 *
 */
@XmlRootElement
public class Comment {

	private long id;
	private String comment;
	private String author;
	private Date created;
	
	public Comment() {}
	
	public Comment(long id, String comment, String author) {
		this.id = id;
		this.comment = comment;
		this.author = author;
		created = new Date();
	}
	
	public Comment(String comment, String author) {		
		this.comment = comment;
		this.author = author;
		created = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
