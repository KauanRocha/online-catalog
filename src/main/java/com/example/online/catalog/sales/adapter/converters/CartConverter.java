package com.example.online.catalog.sales.adapter.converters;

import com.example.online.catalog.sales.application.core.domain.order.Cart;

import java.util.function.Consumer;

public class CartConverter {

    private CartConverter() {
    }

    public static com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Cart convertToEntity(Cart domain) {
        var entity = new com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Cart();
        entity.setId(domain.getId());
        entity.setCustomer(CustomerConverter.convertToEntity(domain.getCustomer()));
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());
        entity.setStatus(domain.getStatus());
        return entity;
    }

    public static Cart convertToDomain(com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Cart entity) {
        Cart domain = new Cart();
        domain.setId(entity.getId());
        domain.setCustomer(CustomerConverter.convertToDomain(entity.getCustomer()));
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        domain.setStatus(entity.getStatus());
        return domain;
    }

    public static Cart process(
            Cart domain,
            Consumer<com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Cart> action
    ) {
        var entity = CartConverter.convertToEntity(domain);
        action.accept(entity);
        return CartConverter.convertToDomain(entity);
    }
}
