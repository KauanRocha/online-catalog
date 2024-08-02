package com.example.online.catalog.sales.application.core.usecase;

import com.example.online.catalog.sales.application.core.domain.Company;
import com.example.online.catalog.sales.application.port.in.CatalogServicePort;
import com.example.online.catalog.sales.application.port.out.CompanyPort;

import java.util.List;

public class CatalogUseCase implements CatalogServicePort {

    private final CompanyPort companyPort;

    public CatalogUseCase(CompanyPort companyPort) {
        this.companyPort = companyPort;
    }

    @Override
    public List<Company> searchForStores(String searchTerm, String zipCode) {
        return companyPort.findCompanyByQueryAndZipCode(searchTerm, zipCode);
    }


}
