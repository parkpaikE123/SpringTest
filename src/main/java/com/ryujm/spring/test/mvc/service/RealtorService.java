package com.ryujm.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.mvc.domain.Realtor;
import com.ryujm.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtorByObject(Realtor realtor) {
		int count = realtorRepository.insertRealtorByObject(realtor);
		return count;
		
	}
	
}
