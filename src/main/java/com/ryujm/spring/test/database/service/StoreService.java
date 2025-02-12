package com.ryujm.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.database.domain.Store;
import com.ryujm.spring.test.database.repository.StoreRepository;

@Service
public class StoreService {
	
	// Repository의 selectStore를 위해 멤버변수 선언 (Spring이 자동 주입) 
	@Autowired
	private StoreRepository storeRepository;
	
	public List<Store> getStoreList() {
		
		List<Store> storeList = storeRepository.selectStoreList();
		
		return storeList;
	}
}
