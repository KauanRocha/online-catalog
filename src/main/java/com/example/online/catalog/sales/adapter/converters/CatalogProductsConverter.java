package com.example.online.catalog.sales.adapter.converters;

import com.example.online.catalog.sales.application.core.domain.CatalogProduct;
import org.springframework.beans.BeanUtils;

public class CatalogProductsConverter {

    private CatalogProductsConverter() {
    }

    public static com.example.online.catalog.sales.adapter.outbound.entity.elastic.CatalogProduct convertToEntity(CatalogProduct catalogProduct) {
        var entityCatalogProduct = new com.example.online.catalog.sales.adapter.outbound.entity.elastic.CatalogProduct();
        BeanUtils.copyProperties(catalogProduct, entityCatalogProduct);
        return entityCatalogProduct;
    }

    public static CatalogProduct convertToDomain(com.example.online.catalog.sales.adapter.outbound.entity.elastic.CatalogProduct catalogProduct) {
        var domainCatalogProduct = new CatalogProduct();
        BeanUtils.copyProperties(catalogProduct, domainCatalogProduct);
        return domainCatalogProduct;
    }
}
