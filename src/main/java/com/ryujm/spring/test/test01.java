package com.ryujm.spring.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody()
@Controller
@RequestMapping("/lifecycle/test01")
public class test01 {
	
	@RequestMapping("/1")
	public Map<String, Integer> mapResponse() {
		Map<String, Integer> gradeMap = new HashMap<>();
		
		gradeMap.put("국어", 80);
		gradeMap.put("수학", 90);
		gradeMap.put("영어", 85);
		return gradeMap;
	}
}






