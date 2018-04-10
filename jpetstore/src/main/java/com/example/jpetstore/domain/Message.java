package com.example.jpetstore.domain;

public class Message {
	
	/* Private Fields */
	private int senderId;
	private int receiverId;
	private String title;
	private String context;
	private String date;
	
	/* Getter & Setter */
	public int getSender() {
		return senderId;
	}
	public void setSender(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiver() {
		return receiverId;
	}
	public void setReceiver(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	/* Methods */
	
}
