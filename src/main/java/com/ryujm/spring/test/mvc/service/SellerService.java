package com.ryujm.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.mvc.domain.Seller;
import com.ryujm.spring.test.mvc.repository.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	public int addSeller(
						String nickname
						, String profileImage
						, double temperature
			) {
		int count = sellerRepository.insertSeller(nickname, profileImage, temperature);
		return count;	
	}
	public Seller getLastSeller() {
		return sellerRepository.selectLastSeller();
	}
	
}