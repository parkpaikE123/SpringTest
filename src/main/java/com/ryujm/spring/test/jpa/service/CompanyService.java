package com.ryujm.spring.test.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryujm.spring.test.jpa.domain.Company;
import com.ryujm.spring.test.jpa.repository.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	// create 기능
	public Company createCompany(String name
						, String busniess
						, String scale
						, int headcount
						, String region) {
		
		Company company = Company.builder()
						.name(name)
						.busniess(busniess)
						.scale(scale)
						.headcount(headcount)
						.region(region)
						.build();
		
		Company result = companyRepository.save(company);
		
		return result;
	}
	// update 기능
	// id를 기준으로 탐색 -> 규모, 사원수 수정
	public Company updateCompany(int id, String scale, int headcount) {
		// nullPointerException 방지를 위해 Optional로 감싸줌
		Optional<Company> optionalCompany = companyRepository.findById(id);
		
		if(optionalCompany.isPresent()) {
			Company company = optionalCompany.get();
			
			company = company.toBuilder().scale(scale).headcount(headcount).build();
			
			Company result = companyRepository.save(company);
			return result;
		}
		
		return null;
		
	}
	
	// delete 기능
	// id 를 기준으로 조회, 삭제
	public void deleteCompany(int id) {
		Optional<Company> optionalCompany = companyRepository.findById(id);
//		if(optionalCompany.isPresent()) {
//			Company company = optionalCompany.get();
//			companyRepository.delete(company);
//		}
		
		// 람다식 표현
		optionalCompany.ifPresent(company -> companyRepository.delete(company));
	}
	
}
