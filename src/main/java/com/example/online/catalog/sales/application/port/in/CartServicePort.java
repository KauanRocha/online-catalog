package com.example.online.catalog.sales.application.port.in;

import com.example.online.catalog.sales.application.core.domain.order.Cart;

public interface CartServicePort {

    Cart createCart(Cart cart, Integer userId);

    Cart updateCart(Cart cart, Integer userId);
}
