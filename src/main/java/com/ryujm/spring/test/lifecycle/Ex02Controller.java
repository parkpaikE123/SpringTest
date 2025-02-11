package com.ryujm.spring.test.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	
	@RequestMapping("/lifecycle/ex02")
	public String thymeleafResponse() {
		return "lifecycle/ex02";
	}
	
}
