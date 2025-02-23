package com.ryujm.spring.test.thymeleaf.repository;

import org.apache.ibatis.annotations.Mapper;

import com.ryujm.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryRepository {

	public WeatherHistory getWeatherHistory();
	
}
