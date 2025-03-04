package com.ryujm.spring.test.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryujm.spring.test.jpa.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
