package com.ryujm.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.mybatis.domain.RealEstate;
import com.ryujm.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {

	@Autowired
	private RealEstateRepository realEstateRepository;
	
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	public List<RealEstate> getRealEstate1(int rentPrice) {
		List<RealEstate> realEstate1 = realEstateRepository.selectRealEstate1(rentPrice);
		return realEstate1;
	}
	
	public List<RealEstate> getRealEstate2(int area, int price) {
		List<RealEstate> realEstate2 = realEstateRepository.selectRealEstate2(area, price);
		return realEstate2;
	}
	
	public int addRealEstateByObject(RealEstate realEstate) {
		int count = realEstateRepository.createRealEstateByObject(realEstate);
		return count;
	}
	
	public int addRealEstate(
						int realtorId
						, String address
						, int area
						, String type
						, int price
						, int rentPrice) {
		int count = realEstateRepository.createEstate(realtorId, address, area, type, price, rentPrice);
		return count;
	}
	
}
