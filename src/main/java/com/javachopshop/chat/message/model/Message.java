package com.javachopshop.chat.message.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	
	@JsonIgnore
	private long id;
	private long channelId;
	private String author;
	private String body;
	private Date timestamp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getChannelId() {
		return channelId;
	}
	public void setChannelId(long channelId) {
		this.channelId = channelId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@JsonProperty
	public Date getTimestamp() {
		return timestamp;
	}
	@JsonIgnore
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
