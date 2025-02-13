package com.ryujm.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.mybatis.domain.RealEstate;
import com.ryujm.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate/select")
public class RealEstateController {
	
	@Autowired
	RealEstateService realEstateService;
	
	// id를 입력받아 해당 행을 조회
	@ResponseBody
	@RequestMapping("/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	// 월세를 입력받아 더 낮은 조건의 매물 조회
	@ResponseBody
	@RequestMapping("/2")
	public List<RealEstate> realEstate1List(@RequestParam("rentPrice") int rentPrice) {
		List<RealEstate> realEstate = realEstateService.getRealEstate1(rentPrice);
		return realEstate;
		
	}
	
	@ResponseBody
	@RequestMapping("/3")
	public List<RealEstate> realEstate2List(@RequestParam("area") int area,@RequestParam("price") int price) {
		List<RealEstate> realEstate = realEstateService.getRealEstate2(area, price);
		return realEstate;
	}
	
	
	
	
	
	
}
