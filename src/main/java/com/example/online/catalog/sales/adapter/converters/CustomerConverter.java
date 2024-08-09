package com.example.online.catalog.sales.adapter.converters;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.User;
import com.example.online.catalog.sales.application.core.domain.order.Customer;

import java.util.function.Consumer;

public class CustomerConverter {

    private CustomerConverter() {
    }

    public static com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Customer convertToEntity(Customer domain) {
        var entity = new com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Customer();
        var entityUser = new User();
        entityUser.setId(domain.getId());
        entity.setUser(entityUser);
        return entity;
    }

    public static Customer convertToDomain(com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Customer entity) {
        var domain = new Customer();
        domain.setId(entity.getUser().getId());
        return domain;
    }

    public static Customer process(
            Customer domain,
            Consumer<com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Customer> action
    ) {
        var entity = CustomerConverter.convertToEntity(domain);
        action.accept(entity);
        return CustomerConverter.convertToDomain(entity);
    }
}
