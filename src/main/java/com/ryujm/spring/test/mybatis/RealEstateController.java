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
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {
	
	@Autowired
	RealEstateService realEstateService;
	
	// id를 입력받아 해당 행을 조회
	@ResponseBody
	@RequestMapping("/select/1")
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateService.getRealEstate(id);
		return realEstate;
	}
	
	// 월세를 입력받아 더 낮은 조건의 매물 조회
	@ResponseBody
	@RequestMapping("/select/2")
	public List<RealEstate> realEstate1List(@RequestParam("rentPrice") int rentPrice) {
		List<RealEstate> realEstate = realEstateService.getRealEstate1(rentPrice);
		return realEstate;
		
	}
	
	@ResponseBody
	@RequestMapping("/select/3")
	public List<RealEstate> realEstate2List(@RequestParam("area") int area
			,@RequestParam("price") int price) {
		List<RealEstate> realEstate = realEstateService.getRealEstate2(area, price);
		return realEstate;
	}
	
	// 객체로 insert 하기
	@ResponseBody
	@RequestMapping("/insert/1")
	public String createRealEstateByObject() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		return "입력 성공 : " + count;
	}
	
	// Parameter로 insert 하기
	@ResponseBody
	@RequestMapping("/insert/2")
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {
		int count = realEstateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		return "입력 성공 :" + count;
	}
	
	// 전달받은 Parameter로 update 하기
	// update내용 = id를 기반으로 추적 (type, price 변경)
	@ResponseBody
	@RequestMapping("/update")
	public String updateRealEstate(@RequestParam("id") int id
									,@RequestParam("type") String type
									,@RequestParam("price") int price) {
		int count = realEstateService.updateRealEstate(22, "전세", 70000);
		return "수정 결과 : " + count;
	}
	
	// Parameter로 Delete 하기
	@ResponseBody
	@RequestMapping("/delete")
	public String deleteRealEstate(@RequestParam("id") int id) {
		int count = realEstateService.deleteRealEstate(id);
		return "삭제 성공 : " + count;
	}
	
	
	
}
