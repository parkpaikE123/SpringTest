package com.ryujm.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {

	public int insertSeller(
							@Param("nickname") String nickname
							, @Param("temperature") double temperature
							, @Param("profileImage") String profileImage
			);
	
}