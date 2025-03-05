package com.ryujm.spring.test.jpa;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.jpa.domain.Recruit;
import com.ryujm.spring.test.jpa.repository.RecruitRepository;

@Controller
@RequestMapping("/jpa/recruit")
public class RecruitController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@ResponseBody
	@GetMapping("/find")
	public List<Recruit> findInfo() {
		List<Recruit> recruitList = null;
		
		// 1. id 로 조회
		// id 가 8인 공고를 조회하고 아래와 같이 출력하세요.
//		recruitList = recruitRepository.findById(8);
//		
		
		// 2. Parameter 조건 조회
		
//		recruitList = recruitRepository.findTop1ByCompanyIdOrderByIdDesc(1);
		
		// 3. 복합 조건 조회
//		recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
		// 4. 복합 조건 조회
//		recruitList = recruitRepository.findByTypeContainingOrSalaryBetween("정규직", 8999, 99999);
		
		// 5. 정렬 제한 조건
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		// 6. 범위 조회
		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		// 7. Native query
		
		LocalDateTime date;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		String deadLine = "2026-04-10";
		
		deadLine.formatted(null)
		
		recruitList = recruitRepository.findByDeadline(date, "정규직", 8100);
		
		
		return recruitList;
	}
	
}
