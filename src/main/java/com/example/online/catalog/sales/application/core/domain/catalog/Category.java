package com.example.online.catalog.sales.application.core.domain.catalog;

import com.example.online.catalog.sales.application.core.domain.Company;

public class Category {

    private Integer id;

    private String name;

    private String description;

    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
