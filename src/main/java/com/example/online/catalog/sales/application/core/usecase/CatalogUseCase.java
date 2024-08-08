package com.example.online.catalog.sales.application.core.usecase;

import com.example.online.catalog.sales.application.core.domain.catalog.CatalogProduct;
import com.example.online.catalog.sales.application.core.domain.Company;
import com.example.online.catalog.sales.application.port.in.CatalogServicePort;
import com.example.online.catalog.sales.application.port.out.CatalogPort;
import com.example.online.catalog.sales.application.port.out.CompanyPort;

import java.util.List;

public class CatalogUseCase implements CatalogServicePort {

    private final CompanyPort companyPort;

    private final CatalogPort catalogPort;

    public CatalogUseCase(CompanyPort companyPort, CatalogPort catalogPort) {
        this.companyPort = companyPort;
        this.catalogPort = catalogPort;
    }

    @Override
    public List<Company> searchForStores(String searchTerm, String zipCode) {
        return companyPort.findCompanyByQueryAndZipCode(searchTerm, zipCode);
    }

    @Override
    public List<CatalogProduct> searchProductsByCompanyId(Integer companyId, String searchTerm) {
        return catalogPort.getCatalogProductsByCompanyId(companyId);
    }

}
