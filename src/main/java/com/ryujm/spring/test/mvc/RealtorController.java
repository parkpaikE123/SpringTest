package com.ryujm.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryujm.spring.test.mvc.domain.Realtor;
import com.ryujm.spring.test.mvc.service.RealtorService;

@Controller
@RequestMapping("/mvc/realtor")
public class RealtorController {
	
	@Autowired
	private RealtorService realtorService;
	
	// input page로 이동
	@GetMapping("/input")
	public String searchRealtor() {
		return "/mvc/realtorInput";
	}
	// input page에서 얻어온 정보 이용
	@GetMapping("/create")
	public String insertRealtor(
			@RequestParam("office") String office
						, @RequestParam("phoneNumber") String  phoneNumber
						, @RequestParam("address") String address
						, @RequestParam("grade") String grade
						, Model model) {
		
		Realtor realtor = new Realtor();
		realtor.setAddress(address);
		realtor.setPhoneNumber(phoneNumber);
		realtor.setAddress(address);
		realtor.setGrade(grade);
		
		int count = realtorService.addRealtorByObject(realtor);
		
		model.addAttribute("realtor", realtor);
		
		// info page로 이동
		return "mvc/realtorInfo";	
	}
	// info page
	@GetMapping("/info")
	public String realtorInfo() {
		return "/mvc/realtorInfo";
	}
	
	
}
