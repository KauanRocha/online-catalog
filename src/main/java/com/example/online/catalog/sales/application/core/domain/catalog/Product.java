package com.example.online.catalog.sales.application.core.domain.catalog;

import com.example.online.catalog.sales.application.core.domain.Company;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

public class Product {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private BigDecimal promotionalPrice;

    private Company company;

    private Category category;

    @ManyToMany
    @JoinTable(
            name = "assoc_products_additional_products",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_additional_product"))
    private Set<Product> additionalProducts;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Product> getAdditionalProducts() {
        return additionalProducts;
    }

    public void setAdditionalProducts(Set<Product> additionalProducts) {
        this.additionalProducts = additionalProducts;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }
}