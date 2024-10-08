package com.example.online.catalog.sales.application.core.domain.catalog;

import java.math.BigDecimal;
import java.util.Set;

public class CatalogProduct {

    private String id;

    private Integer productId;

    private String name;

    private String description;

    private BigDecimal price;

    private Category category;

    private Set<Product> additionalProducts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getAdditionalProducts() {
        return additionalProducts;
    }

    public void setAdditionalProducts(Set<Product> additionalProducts) {
        this.additionalProducts = additionalProducts;
    }
}