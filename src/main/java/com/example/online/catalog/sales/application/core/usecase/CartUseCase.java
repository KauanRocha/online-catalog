package com.example.online.catalog.sales.application.core.usecase;

import com.example.online.catalog.sales.application.core.domain.order.Cart;
import com.example.online.catalog.sales.application.core.domain.order.CartStatusEnum;
import com.example.online.catalog.sales.application.port.in.CartServicePort;
import com.example.online.catalog.sales.application.port.out.CartPort;

import java.time.LocalDateTime;

public class CartUseCase implements CartServicePort {

    private final CartPort cartPort;

    public CartUseCase(CartPort cartPort) {
        this.cartPort = cartPort;
    }

    @Override
    public Cart createCart(Cart cart) {
        var lastCart = cartPort.getLastCartByCustomerId(cart.getCustomer().getId());
        if (lastCart.getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(30L))) {
            throw new IllegalStateException("Last cart still in progress");
        }

        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());
        return cartPort.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        var lastCart = cartPort.getLastCartByCustomerId(cart.getCustomer().getId());
        if (lastCart.getCreatedAt().isBefore(LocalDateTime.now().minusMinutes(30L))) {
            cart.setStatus(CartStatusEnum.EXPIRED);
            cartPort.save(cart);
            throw new IllegalStateException("This cart is expired");
        }

        cart.setCreatedAt(lastCart.getCreatedAt());
        cart.setUpdatedAt(LocalDateTime.now());
        return cartPort.save(cart);
    }

}
