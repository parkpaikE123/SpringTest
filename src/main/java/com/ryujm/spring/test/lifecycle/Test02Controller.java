package com.ryujm.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lifecycle/test02")
public class Test02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> listResponse() {
		
		List<Map<String, Object>> movieList = new ArrayList<>();
		Map<String, Object> movieMap = new HashMap<>();
				
			movieMap.put("rate", 15);
			movieMap.put("director", "봉준호");
			movieMap.put("time", "131");
			movieMap.put("title", "기생충");
			movieList.add(movieMap);
		
		
			movieMap.put("rate", 0);
			movieMap.put("director", "로베르토 베니니");
			movieMap.put("time", "116");
			movieMap.put("title", "인생은 아름다워");
			movieList.add(movieMap);
		
		
			movieMap.put("rate", 12);
			movieMap.put("director", "크리스토퍼 놀란");
			movieMap.put("time", "147");
			movieMap.put("title", "인셉션");
			movieList.add(movieMap);
		
		
			movieMap.put("rate", 19);
			movieMap.put("director", "윤종빈");
			movieMap.put("time", "133");
			movieMap.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
			movieList.add(movieMap);
		
		
			movieMap.put("rate", 15);
			movieMap.put("director", "프란시스 로렌스");
			movieMap.put("time", "137");
			movieMap.put("title", "헝거게임");
			movieList.add(movieMap);
		
		return movieList;
		
		
	}
	
}
