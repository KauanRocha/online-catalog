package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.catalog.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Optional<Catalog> findOneByCompanyId(Integer companyId);
}
