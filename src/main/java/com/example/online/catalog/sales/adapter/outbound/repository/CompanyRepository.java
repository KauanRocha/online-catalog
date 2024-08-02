package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.application.core.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAllByZipCode(String zipCode);

    List<Company> findAllByZipCodeAndNameContainingIgnoreCase(String zipCode, String term);
}
