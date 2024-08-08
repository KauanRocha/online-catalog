package com.example.online.catalog.sales.application.core.domain.catalog;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.Company;

import java.util.List;

public class Catalog {

    private Integer id;

    private String name;

    private String description;

    private Company company;

    private List<CatalogProduct> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<CatalogProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CatalogProduct> products) {
        this.products = products;
    }
}