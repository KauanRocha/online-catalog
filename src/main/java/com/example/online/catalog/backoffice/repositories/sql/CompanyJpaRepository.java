package com.example.online.catalog.backoffice.repositories.sql;

import com.example.online.catalog.backoffice.models.sql.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<Company, Integer> {
    Page<Company> findAllByNameContainingIgnoreCase(String query, Pageable build);
}
