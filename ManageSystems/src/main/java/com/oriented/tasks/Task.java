package com.oriented.tasks;

public class Task {
	private String task_id,user_id,text,name,state;

	public void setTask_Id(String task_id) {
		this.task_id=task_id;
	}
	public String geTask_Id() {
		return task_id;
	}
	public void setUser_Id(String user_id) {
		this.user_id=user_id;
	}
	public String getUser_Id() {
		return user_id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setText(String text) {
		this.text=text;
	}
	public String getText() {
		return text;
	
}
	
	public void setState(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	
}
}
