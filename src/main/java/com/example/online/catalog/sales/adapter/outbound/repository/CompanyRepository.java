package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findAllByAddressZipCode(String zipCode);

    List<Company> findAllByAddressZipCodeAndNameContainingIgnoreCase(String zipCode, String term);
}
