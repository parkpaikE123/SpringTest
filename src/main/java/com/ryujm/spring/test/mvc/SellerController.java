package com.ryujm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.mvc.service.SellerService;



@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// input 기능
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
								@RequestParam("nickname") String nickname
								, @RequestParam("profileImage") String profileImgae
								, @RequestParam("temperature") double temperature
			) {
		int count = sellerService.addSeller(nickname, profileImgae, temperature);
		return "추가 성공 : " + count;
	}
	
	// input 주소 연결
	@GetMapping("/input")
	public String inputSeller() {
		
		return "/mvc/sellerInput";
	}
	
}