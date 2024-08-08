package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.order.Cart;

public interface CartPort {

    Cart getLastCartByCustomerId(Integer customerId);

    Cart save(Cart cart);
}
