package com.ryujm.spring.test.jpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ryujm.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>{

	
	// companyId로 해당하는 정보 조회
	public List<Recruit> findTop1ByCompanyIdOrderByIdDesc(int companyid);
	
	// 웹 back-end 개발자 이고 정규직인 공고를 조회
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// 정규직 이거나 연봉이 9000 이상인 공고 조회
	public List<Recruit> findByTypeContainingOrSalaryGreaterThanEqual(String type, int salary);
	
	// 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 성남시 분당구가 지역인 연봉 7000이상 8500이하 공고 조회
	public List<Recruit> findByRegionAndSalaryBetween(String region,int start, int end);
	
	// 마감일이 2026-04-10 이후이고 연봉이 8100이상인 정규직공고를 연봉 내림차순 조회
	@Query(value="SELECT * FROM `recruit`"
			+ "WHERE `deadline` > :deadline"
			+ " AND `salary` >= :salary"
			+ " AND `type` = :type"
			+ " ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> selectByNativeQuery(@Param("deadline") LocalDate deadline
											, @Param("salary") int salary
											, @Param("type") String type);
}
