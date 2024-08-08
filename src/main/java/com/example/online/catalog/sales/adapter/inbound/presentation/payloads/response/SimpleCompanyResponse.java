package com.example.online.catalog.sales.adapter.inbound.presentation.payloads.response;

import com.example.online.catalog.sales.application.core.domain.order.Address;
import com.example.online.catalog.sales.application.core.domain.Company;

public class SimpleCompanyResponse {

    private final Company company;

    public SimpleCompanyResponse(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return company.getAddress();
    }

    public String getDescription() {
        return company.getDescription();
    }


    public Integer getId() {
        return company.getId();
    }

    public String getName() {
        return company.getName();
    }

}
