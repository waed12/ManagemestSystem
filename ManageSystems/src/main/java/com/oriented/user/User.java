package com.oriented.user;

public class User {
	private String id,name,password,city,text,state;

	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
		
	}
	public void setPassword(String password) {
		
		this.password=password;
	}
//
	public void setCity(String city) {
		this.city =city;
	}
	public String getCity() {
		return city;
	}
	public void setText(String text) {
		this.text =text;
	}
	public String getText() {
		return text;
	}
	public void setState(String state) {
		this.state =state;
	}
	public String getState() {
		return state;
	}
}
