package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.application.core.domain.order.Cart;
import com.example.online.catalog.sales.application.port.out.CartPort;
import org.springframework.stereotype.Service;

@Service
public class CartAdapter implements CartPort {
    @Override
    public Cart getLastCartByCustomerId(Integer customerId) {
        return null;
    }

    @Override
    public Cart save(Cart cart) {
        return null;
    }
}
