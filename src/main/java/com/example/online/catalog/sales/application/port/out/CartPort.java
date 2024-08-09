package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.order.Cart;

import java.util.Optional;

public interface CartPort {

    Optional<Cart> getLastCartByCustomerId(Integer customerId);

    Cart save(Cart cart);

    Optional<Cart> getLastCartByCustomerIdAndCreatedAtAfterOrderByCreatedAtDesc(Integer id);
}
