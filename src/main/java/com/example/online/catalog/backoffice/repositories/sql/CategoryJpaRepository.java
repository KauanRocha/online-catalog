package com.example.online.catalog.backoffice.repositories.sql;

import com.example.online.catalog.backoffice.models.sql.Category;
import com.example.online.catalog.backoffice.models.sql.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {
    void deleteByIdAndCompany(Integer id, Company company);

    Optional<Category> findByIdAndCompany(Integer id, Company company);

    Page<Category> findAllByCompanyAndNameContainingIgnoreCase(Company company, String query, Pageable build);
}
