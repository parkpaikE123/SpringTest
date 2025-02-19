package com.ryujm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.mvc.domain.Seller;
import com.ryujm.spring.test.mvc.service.SellerService;



@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// input 기능
//	@ResponseBody
	@PostMapping("/create")
	public String createSeller(
								@RequestParam("nickname") String nickname
								, @RequestParam("profileImage") String profileImgae
								, @RequestParam("temperature") double temperature
			) {
		int count = sellerService.addSeller(nickname, profileImgae, temperature);
		return "redirect:/mvc/seller/info";
	}
	// input 주소 연결
	@GetMapping("/input")
	public String inputSeller() {
		
		return "/mvc/sellerInput";
	}
	
	// 가장 최근 추가 된 판매자 정보 조회
	@GetMapping("/info")
	public String sellerInfo(@RequestParam(value="id", required=false) Integer id
			, Model model) {
		Seller seller = null;
		if(id == null) {
			seller = sellerService.getLastSeller();
		} else {
			seller = sellerService.getSeller(id);
		}
		model.addAttribute("seller", seller);
		return "/mvc/sellerInfo";
	}
	
//	// seller 검색 - keyword 요청
//	@GetMapping("/search")
//	public String searchSeller() {
//		return "/mvc/sellerSearch";
//	}
//	
//	// keyword 를 받아온 후 수행
//	@GetMapping("/check")
//	public String checkSeller(Model model,@RequestParam("keyword") String keyword) {
//		Seller seller = sellerService.searchSeller(keyword);
//		model.addAttribute("seller", seller);
//		return "/mvc/sellerInfo";
//		
//	}
	
	
}