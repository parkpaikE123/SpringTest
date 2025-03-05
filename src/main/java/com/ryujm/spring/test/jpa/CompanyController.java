package com.ryujm.spring.test.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryujm.spring.test.jpa.domain.Company;
import com.ryujm.spring.test.jpa.service.CompanyService;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	// create 기능
	@ResponseBody
	@GetMapping("/create")
	public List<Company> createCompany() {
		List<Company> companyList = new ArrayList<>();
		Company company1 = companyService.createCompany("넥손", "컨텐츠 게임", "대기업", 3585, "서울시 동동구");
		Company company2 = companyService.createCompany("버블팡", "여신 금융업", "대기업", 6834, "서울시 북북구");
		
		companyList.add(company1);
		companyList.add(company2);
		
		return companyList;
	}
	
	// update 기능
	// id를 기준으로 추적하여 scale, headcount 컬럼값을 변경
	@ResponseBody
	@GetMapping("/update")
	public Company updateCompany() {
		Company company = companyService.updateCompany(12, "중소 기업", 34);
		return company;
	}
	
	// delete 기능
	// id를 파라미터로 입력하여 삭제
	// return 값은 성공여부를 위함
	@ResponseBody
	@GetMapping("/delete")
	public String deleteCompany() {
		companyService.deleteCompany(12);
		return "파산 성공!";
	}
}
