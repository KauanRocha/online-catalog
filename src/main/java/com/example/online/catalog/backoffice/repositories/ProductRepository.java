package com.example.online.catalog.backoffice.repositories;

import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.models.sql.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByIdAndCompany(Integer id, Company company);

    Page<Product> findAllByCompanyAndNameContainingIgnoreCase(Company company, String q, Pageable build);

    void deleteByIdAndCompany(Integer id, Company company);
}
