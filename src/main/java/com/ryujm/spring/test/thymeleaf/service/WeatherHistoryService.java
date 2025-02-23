package com.ryujm.spring.test.thymeleaf.service;

import org.springframework.stereotype.Service;

import com.ryujm.spring.test.thymeleaf.domain.WeatherHistory;
import com.ryujm.spring.test.thymeleaf.repository.WeatherHistoryRepository;

@Service
public class WeatherHistoryService {

	WeatherHistoryRepository weatherHistoryRepository;
	
	public WeatherHistory getWeatherList() {
		return weatherHistoryRepository.getWeatherHistory();
	}
	
}
