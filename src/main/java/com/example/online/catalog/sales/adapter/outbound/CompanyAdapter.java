package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.adapter.converters.CompanyConverter;
import com.example.online.catalog.sales.adapter.outbound.repository.CompanyRepository;
import com.example.online.catalog.sales.application.core.domain.Company;
import com.example.online.catalog.sales.application.port.out.CompanyPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAdapter implements CompanyPort {

    private final CompanyRepository companyRepository;

    public CompanyAdapter(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findCompanyByQueryAndZipCode(String zipCode, String term) {
        if (term == null || term.isBlank()) {
            return companyRepository.findAllByAddressZipCode(zipCode)
                    .stream()
                    .map(CompanyConverter::convertToDomain)
                    .toList();
        }
        return companyRepository.findAllByAddressZipCodeAndNameContainingIgnoreCase(zipCode, term)
                .stream()
                .map(CompanyConverter::convertToDomain)
                .toList();
    }
}
