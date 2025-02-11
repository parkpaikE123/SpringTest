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
	public Map<String, String> postMapping(String title,String user,String content) {
		Map<String, String> intMap = new HashMap<>();
		intMap.put("title", title);
		intMap.put("user", user);
		intMap.put("content", content);
		return intMap;
	}
	
}
