package com.ryujm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryujm.spring.test.mvc.service.SellerService;



@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// input 주소 연결
	@PostMapping("/input")
	public String inputSeller() {
			
		return "/mvc/sellerInput";
	}
	// input 기능
	@PostMapping("/create")
	public String inputSeller1(
								@RequestParam("nickname") String nickname
								, @RequestParam("temperature") double temperature
								, @RequestParam("profileImage") String profileImgae
			) {
		int count = sellerService.addSeller(nickname, temperature, profileImgae);
		return "추가 성공 : " + count;
	}
	
}