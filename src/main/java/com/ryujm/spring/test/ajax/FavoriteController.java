package com.ryujm.spring.test.ajax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.ajax.domain.Favorite;
import com.ryujm.spring.test.ajax.service.FavoriteService;

@RequestMapping("/ajax/favorite")
@Controller
public class FavoriteController {
	
	// 입력창 접속 View
	@GetMapping("/input")
	public String inputFavaorite() {
		return "/ajax/favorite/input";
	}
	
	@Autowired
	private FavoriteService favoriteService;
	
	// 사이트 이름과 url을 전달 받고 저장하는 API
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> addFavorite(
					@RequestParam("name") String name
					,@RequestParam("url") String url
					) {
		int count = favoriteService.createFavorite(name, url);
		
		// 성공, 실패의 여부를 데이터 형식으로 전달
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/list") 
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = new ArrayList<>();
		
		Favorite favorite = null;
		
		favoriteList = favoriteService.getFavoriteList(favorite);
		
		model.addAttribute("favorite", favoriteList);
		
		return"/ajax/favorite/favoritelist";
	}
	
	// 중복확인 API
	@ResponseBody
	@PostMapping("duplicate-url")
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		Map<String, Boolean> resultMap = new HashMap<>();
		if(isDuplicate) {
			resultMap.put("isDuplicate", true);
		} else {
			resultMap.put("isDuplicate", false);
		}
		return resultMap;
	}
	// Delete API
	public deleteRow(@RequestParam("id") int id) {
		
	}
	
	
}
