package com.example.online.catalog.manager.catalog;

import com.example.online.catalog.manager.common.exceptions.BackOfficeNotFoundException;
import com.example.online.catalog.manager.company.Company;
import com.example.online.catalog.manager.common.FilterRequest;
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
