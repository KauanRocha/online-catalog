package com.example.online.catalog.manager.company;

import com.example.online.catalog.manager.common.exceptions.BackOfficeNotFoundException;
import com.example.online.catalog.manager.common.FilterRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyJpaRepository companyJpaRepository;

    public CompanyService(CompanyJpaRepository companyJpaRepository) {
        this.companyJpaRepository = companyJpaRepository;
    }

    public Page<Company> findAll(FilterRequest filter) {
        return companyJpaRepository.findAllByNameContainingIgnoreCase(filter.query(), filter.build());
    }

    public Company findById(Integer id) {
        return companyJpaRepository.findById(id)
                .orElseThrow(BackOfficeNotFoundException::new);
    }

    private Company save(CompanyRequest companyRequest) {
        var company = companyRequest.build();
        return companyJpaRepository.save(company);
    }

    public Company update(CompanyRequest companyRequest) {
        return save(companyRequest);
    }

    public Company create(CompanyRequest companyRequest) {
        return save(companyRequest);
    }

    public void delete(Integer id) {
        companyJpaRepository.deleteById(id);
    }
}
