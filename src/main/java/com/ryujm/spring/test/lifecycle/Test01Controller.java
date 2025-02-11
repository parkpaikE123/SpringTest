package com.ryujm.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody()
@Controller
@RequestMapping("/lifecycle/test01234")
public class Test01Controller {
	
	@RequestMapping("/1")
	public String testProject() {
		return "<h1>테스트 프로젝트 완성</h1>"
				+ "<h2>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h2>";
	}
	
	
	@RequestMapping("/2")
	public Map<String, Integer> mapResponse() {
		Map<String, Integer> gradeMap = new HashMap<>();
		
		gradeMap.put("국어", 80);
		gradeMap.put("수학", 90);
		gradeMap.put("영어", 85);
		return gradeMap;
	}
}






