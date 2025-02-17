package com.ryujm.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ryujm.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {
	// id를 통한 행 조회
	public RealEstate selectRealEstate(@Param("id") int id);
	
	//월세 조건을 통한 행 조회
	public List<RealEstate> selectRealEstate1(@Param("rentPrice") int rentPrice);
	
	// 넓이 가격을 조건으로 조회
	public List<RealEstate> selectRealEstate2(@Param("area")int area,@Param("price") int price);
	
	// 객체로 insert
	public int createRealEstateByObject(RealEstate realEstate);
	
	// Parameter로 insert 하기
	public int createEstate(@Param("realtorId") int realtorId
						, @Param("address") String address
						, @Param("area") int area
						, @Param("type") String type
						, @Param("price") int price
						, @Param("rentPrice") int rentPrice);
	
	public int updateRealEstate(@Param("id") int id
								,@Param("type") String type
								,@Param("price") int price);
	
	// Parameter로 delete 하기
	public int deleteRealEstate(@Param("id") int id);
}

