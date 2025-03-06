package com.ryujm.spring.test.jpa;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
//		recruitList = recruitRepository.findByTypeContainingOrSalaryGreaterThanEqual("정규직", 9000);
		
		// 5. 정렬 제한 조건
//		recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
		
		// 6. 범위 조회
//		recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
		
		// 7. Native query
//		마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회하세요.
		recruitList = recruitRepository.selectByNativeQuery(LocalDate.of(2026, 4, 10), 8100, "정규직");
		
		return recruitList;
	}
		
	
}
