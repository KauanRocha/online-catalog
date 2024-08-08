package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.catalog.CatalogProduct;

import java.util.List;

public interface CatalogPort {

    List<CatalogProduct> getCatalogProductsByCompanyId(Integer company);
}
