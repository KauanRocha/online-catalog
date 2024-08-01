package com.example.online.catalog.backoffice.services;

import com.example.online.catalog.backoffice.exceptions.BackOfficeNotFoundException;
import com.example.online.catalog.backoffice.models.sql.Catalog;
import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.payloads.requests.CatalogRequest;
import com.example.online.catalog.backoffice.payloads.requests.FilterRequest;
import com.example.online.catalog.backoffice.repositories.sql.CatalogJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CatalogService {

    private final CatalogJpaRepository catalogJpaRepository;

    public CatalogService(CatalogJpaRepository catalogJpaRepository) {
        this.catalogJpaRepository = catalogJpaRepository;
    }

    public Page<Catalog> findAll(Company company, FilterRequest filter) {
        return catalogJpaRepository.findAllByCompanyAndNameContainingIgnoreCase(company, filter.query(), filter.build());
    }

    public Catalog findById(Integer id, Company company) {
        return catalogJpaRepository.findByIdAndCompany(id, company)
                .orElseThrow(BackOfficeNotFoundException::new);
    }

    private Catalog save(CatalogRequest catalogRequest, Company company) {
        var catalog = catalogRequest.build();
        catalog.setCompany(company);
        return catalogJpaRepository.save(catalog);
    }

    public Catalog update(CatalogRequest catalogRequest, Company company) {
        return save(catalogRequest, company);
    }

    public Catalog create(CatalogRequest catalogRequest, Company company) {
        return save(catalogRequest, company);
    }

    public void delete(Integer id, Company company) {
        catalogJpaRepository.deleteByIdAndCompany(id, company);
    }
}
