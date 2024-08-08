package com.example.online.catalog.sales.application.port.in;

import com.example.online.catalog.sales.application.core.domain.catalog.CatalogProduct;
import com.example.online.catalog.sales.application.core.domain.Company;

import java.util.List;

public interface CatalogServicePort {

    List<Company> searchForStores(String zipCode, String term);

    List<CatalogProduct> searchProductsByCompanyId(Integer companyId, String searchTerm);
}
