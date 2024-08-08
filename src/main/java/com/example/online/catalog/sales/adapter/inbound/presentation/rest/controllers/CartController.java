package com.example.online.catalog.sales.adapter.inbound.presentation.rest.controllers;

import com.example.online.catalog.auth.adapters.inbound.resolvers.UserId;
import com.example.online.catalog.sales.application.core.domain.order.Cart;
import com.example.online.catalog.sales.application.port.in.CartServicePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/sales/cart")
public class CartController {

    private final CartServicePort cartServicePort;

    public CartController(CartServicePort cartServicePort) {
        this.cartServicePort = cartServicePort;
    }

    @PostMapping(path = "/stores")
    public Integer create(@UserId Integer userId, @RequestBody Cart cart) {
        return cartServicePort.createCart(cart).getId();
    }
}