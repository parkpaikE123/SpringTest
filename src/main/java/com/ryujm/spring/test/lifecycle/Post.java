package com.ryujm.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class Post {

	private String title;
	private String user;
	private String content;
	
	public Post(String title, String user, String content) {
		this.content = content;
		this.user = user;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public String getUser() {
		return user;
	}
	public String getContent() {
		return content;
	}
	
}
