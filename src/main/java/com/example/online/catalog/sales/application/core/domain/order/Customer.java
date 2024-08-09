package com.example.online.catalog.sales.application.core.domain.order;

public class Customer {

    private Integer id;

    public Customer(User user) {
        this.id = user.getId();
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
