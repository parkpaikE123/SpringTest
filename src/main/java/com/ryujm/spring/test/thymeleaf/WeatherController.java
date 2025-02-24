package com.ryujm.spring.test.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.thymeleaf.domain.WeatherHistory;
import com.ryujm.spring.test.thymeleaf.service.WeatherHistoryService;
@Controller
@RequestMapping("/thymeleaf/weather")
public class WeatherController {

	@Autowired
	private WeatherHistoryService weatherHistoryService;
	
	List<WeatherHistory> weatherList = new ArrayList<>();
	@GetMapping("/list")
	public String test04(Model model) {
		WeatherHistory weatherHistory = null;
		weatherList = weatherHistoryService.getWeatherList(weatherHistory);
		model.addAttribute("weatherHistory", weatherList);
		return "/thymeleaf/weather/list";
	}
	@GetMapping("/input")
	public String weatherInput() {
		return "/thymeleaf/weather/weatherInput";
	}
	
	@GetMapping("/create")
	public String addWeather(
//						@DateTimeFormat(pattern="yyyy년 M월 d일") @RequestParam("date") LocalDate date // 2025년 2월 24일
//						, @RequestParam("weather") String weather
//						,@RequestParam("microDust") String microDust
//						,@RequestParam("temperatures") double temperatures
//						,@RequestParam("precipitation") double precipitation
//						,@RequestParam("windSpeed") double windSpeed
			@ModelAttribute WeatherHistory weather) {
			
//		int count = weatherHistoryService.addWeatherHistory(date,weather,microDust,temperatures,precipitation,windSpeed);
		int count = weatherHistoryService.addWeatherByObject(weather);
		
		return "redirect:/thymeleaf/weather/list";
	}
	
}
