package com.ryujm.spring.test.thymeleaf.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ryujm.spring.test.thymeleaf.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryRepository {

	public List<WeatherHistory> getWeatherHistory(WeatherHistory weatherHistory);
	
	public int createWetherHistory(
									@Param("date") LocalDate date
									,@Param("weather") String weather
									,@Param("microDust") String microDust
									,@Param("temperatures") double temperatures
									,@Param("precipitation") double precipitation
									,@Param("windSpeed") double windSpeed
									);
	public int insertWeatherByObject(WeatherHistory weather);
	
	
}
