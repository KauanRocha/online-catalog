package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.Company;

import java.util.List;

public interface CompanyPort {
    List<Company> findCompanyByQueryAndZipCode(String cep, String term);
}
