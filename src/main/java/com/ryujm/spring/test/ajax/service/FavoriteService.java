package com.ryujm.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.ajax.domain.Favorite;
import com.ryujm.spring.test.ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository; 
	
	public int createFavorite(String name,String url) {
		int count = favoriteRepository.insertFavorite(name, url);
		return count;
	}
	
	public List<Favorite> getFavoriteList(Favorite favorite) {
		return favoriteRepository.getfavorite(favorite);
	}
	// 중복확인 서비스
	public boolean isDuplicateUrl(String url) {
		int count = favoriteRepository.selectCountByUrl(url);
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	// 삭제 기능
	public int deleteRow(int id) {
		 int count = favoriteRepository.deleteColumn(id);
		 return count;
	}
	
}
