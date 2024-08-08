package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.adapter.converters.CatalogProductsConverter;
import com.example.online.catalog.sales.adapter.outbound.exceptions.EntityNotFoundException;
import com.example.online.catalog.sales.adapter.outbound.repository.CatalogRepository;
import com.example.online.catalog.sales.application.core.domain.catalog.CatalogProduct;
import com.example.online.catalog.sales.application.port.out.CatalogPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogAdapter implements CatalogPort {

    private final CatalogRepository catalogRepository;

    public CatalogAdapter(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<CatalogProduct> getCatalogProductsByCompanyId(Integer companyId) {
        var a = catalogRepository.findOneByCompanyId(companyId)
                .orElseThrow(EntityNotFoundException::new);


        return a .getProducts().stream()
                .map(CatalogProductsConverter::convertToDomain)
                .toList();
    }
}
