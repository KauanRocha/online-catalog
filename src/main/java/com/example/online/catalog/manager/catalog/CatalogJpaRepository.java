package com.example.online.catalog.manager.catalog;

import com.example.online.catalog.manager.company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogJpaRepository extends JpaRepository<Catalog, Integer> {
    Page<Catalog> findAllByCompanyAndNameContainingIgnoreCase(Company company, String query, Pageable build);

    Optional<Catalog> findByIdAndCompany(Integer id, Company company);

    void deleteByIdAndCompany(Integer id, Company company);
}
