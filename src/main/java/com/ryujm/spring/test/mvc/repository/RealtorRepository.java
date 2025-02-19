package com.ryujm.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ryujm.spring.test.mvc.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtorByObject(Realtor realtor);
	
}
