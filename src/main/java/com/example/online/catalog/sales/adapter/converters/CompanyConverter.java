package com.example.online.catalog.sales.adapter.converters;

import com.example.online.catalog.sales.application.core.domain.Company;
import org.springframework.beans.BeanUtils;

public class CompanyConverter {

    private CompanyConverter() {
    }

    public static com.example.online.catalog.sales.adapter.outbound.entity.sql.Company convertToEntity(Company company) {
        var entityCompany = new com.example.online.catalog.sales.adapter.outbound.entity.sql.Company();
        BeanUtils.copyProperties(company, entityCompany);
        return entityCompany;
    }

    public static Company convertToDomain(com.example.online.catalog.sales.adapter.outbound.entity.sql.Company company) {
        var domainCompany = new Company();
        BeanUtils.copyProperties(company, domainCompany);
        return domainCompany;
    }
}
