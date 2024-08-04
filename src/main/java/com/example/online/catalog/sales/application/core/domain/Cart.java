package com.example.online.catalog.sales.application.core.domain;

import com.example.online.catalog.sales.application.core.domain.enums.CartStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {

    private Integer id;

    private List<CartProduct> products;

    private CartStatusEnum status;

    private Customer customer;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CartStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CartStatusEnum status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
