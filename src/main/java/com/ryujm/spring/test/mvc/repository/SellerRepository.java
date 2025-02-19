package com.ryujm.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ryujm.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {

	public int insertSeller(
							@Param("nickname") String nickname
							, @Param("profileImage") String profileImage
							, @Param("temperature") double temperature);

	// 가장 최근 추가된 판매자 정보
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id") int id);
	
	// 검색된 판매자 정보
//	public Seller searchSeller(@Param("keyword") String keyword);
}