package com.ryujm.spring.test.ajax;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.ajax.domain.Booking;
import com.ryujm.spring.test.ajax.service.BookingService;

@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;	
	
	@GetMapping("/list")
	public String getBookingList(Model model) {
		
		List<Booking> bookingList = new ArrayList<>();
		
		Booking booking = null;
		
		bookingList = bookingService.getBookingList(booking);
		
		model.addAttribute("booking", bookingList);
		
		return "/ajax/booking/list";
	}
	
	// 예약하기 페이지
	@GetMapping("/input")
	public String insertBooking() {
		return "/ajax/booking/input";
	}
	
	// 예약하기 기능 API
	@ResponseBody
	@PostMapping("/insert")
	public Map<String, String> setBooking(@RequestParam("name") String name
					,@RequestParam("date") LocalDate date
					,@RequestParam("day") int day
					,@RequestParam("headcount") int headcount
					,@RequestParam("phoneNumber") String phoneNumber) {
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		// {"result":"success"}
		// {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	// 삭제기능 API
	@ResponseBody
	@GetMapping("/delete")
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 예약 조회 기능 API
	@ResponseBody
	@GetMapping("/info")
	public Map<String, Object> bookingInfo(@RequestParam("name") String name
				,@RequestParam("phoneNumber") String phoneNumber) {
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		// 조회 성공 {"result":"success", "data":{"name":name, "day":3, "headcount":3 ,"phoneNumber":phoneNumber...}}
		// 조회 실패 {"result":"fail"}
		Map<String, Object> resultMap = new HashMap<>();
		if(booking != null) {
			// 성공
			resultMap.put("result", "success");
			resultMap.put("data", booking);
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	@GetMapping("/main")
	public String mainBooking() {
		return "/ajax/booking/main";
	}
	
	
	
	
	
}
