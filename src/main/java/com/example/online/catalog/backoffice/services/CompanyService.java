package com.example.online.catalog.backoffice.services;

import com.example.online.catalog.backoffice.models.sql.Company;
import com.example.online.catalog.backoffice.payloads.requests.CompanyRequest;
import com.example.online.catalog.backoffice.payloads.requests.FilterRequest;
import com.example.online.catalog.backoffice.repositories.CompanyRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Page<Company> findAll(FilterRequest filter) {
        return companyRepository.findAllByNameContainingIgnoreCase(filter.query(), filter.build());
    }

    public Optional<Company> findById(Integer id) {
        return companyRepository.findById(id);
    }

    private Company save(CompanyRequest companyRequest) {
        var company = companyRequest.build();
        return companyRepository.save(company);
    }

    public Company update(CompanyRequest companyRequest) {
        return save(companyRequest);
    }

    public Company create(CompanyRequest companyRequest) {
        return save(companyRequest);
    }

    public void delete(Integer id) {
        companyRepository.deleteById(id);
    }
}
