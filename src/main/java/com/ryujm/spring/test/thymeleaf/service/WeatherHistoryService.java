package com.ryujm.spring.test.thymeleaf.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.thymeleaf.domain.WeatherHistory;
import com.ryujm.spring.test.thymeleaf.repository.WeatherHistoryRepository;

@Service
public class WeatherHistoryService {
	
	@Autowired
	WeatherHistoryRepository weatherHistoryRepository;
	
	public List<WeatherHistory> getWeatherList(WeatherHistory weatherHistory) {
		return weatherHistoryRepository.getWeatherHistory(weatherHistory);
	}
	
	public int addWeatherHistory(
								LocalDate date
								,String wether
								,String microDust
								,double temperatures
								,double precipitation
								,double windSpeed) {
		int count = weatherHistoryRepository.createWetherHistory(date, microDust, microDust, temperatures, precipitation, windSpeed);
		return count;
	}
	public int addWeatherByObject(WeatherHistory weather) {
		return weatherHistoryRepository.insertWeatherByObject(weather);
	}
	
	
}
