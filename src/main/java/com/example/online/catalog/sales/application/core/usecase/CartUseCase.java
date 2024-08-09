package com.example.online.catalog.sales.application.core.usecase;

import com.example.online.catalog.sales.application.core.domain.order.Cart;
import com.example.online.catalog.sales.application.core.domain.order.CartStatusEnum;
import com.example.online.catalog.sales.application.core.domain.order.Customer;
import com.example.online.catalog.sales.application.core.domain.order.User;
import com.example.online.catalog.sales.application.port.in.CartServicePort;
import com.example.online.catalog.sales.application.port.out.CartPort;
import com.example.online.catalog.sales.application.port.out.CustomerPort;

import java.time.LocalDateTime;

public class CartUseCase implements CartServicePort {

    private final CartPort cartPort;

    private final CustomerPort customerPort;

    public CartUseCase(CartPort cartPort, CustomerPort customerPort) {
        this.cartPort = cartPort;
        this.customerPort = customerPort;
    }

    @Override
    public Cart createCart(Cart cart, Integer userId) {
        var customer = findCustomer(userId);

        cart.setCustomer(customer);
        cartPort.getLastCartByCustomerId(cart.getCustomer().getId()).ifPresent(lastCart ->
        {
            if (lastCart.getCreatedAt().isAfter(LocalDateTime.now().minusMinutes(30L))) {
                throw new IllegalStateException("Last cart still in progress");
            }
        });

        cart.setStatus(CartStatusEnum.IN_PROGRESS);
        cart.setCreatedAt(LocalDateTime.now());
        cart.setUpdatedAt(LocalDateTime.now());
        return cartPort.save(cart);
    }

    @Override
    public Cart updateCart(Cart cart, Integer userId) {
        var customer = findCustomer(userId);
        cart.setCustomer(customer);

        cartPort.getLastCartByCustomerIdAndCreatedAtAfterOrderByCreatedAtDesc(customer.getId()).ifPresentOrElse(
                lastCart -> {
                    cart.setCreatedAt(lastCart.getCreatedAt());
                    cart.setUpdatedAt(LocalDateTime.now());
                    cartPort.save(cart);
                },
                () -> {
                    cart.setStatus(CartStatusEnum.EXPIRED);
                    cartPort.save(cart);
                    throw new IllegalStateException("This cart is expired");
                }
        );
        return cart;
    }

    private Customer findCustomer(Integer userId) {
        return customerPort.findById(userId).
                orElseGet( () -> {
                    var user = new User();
                    user.setId(userId);
                    var newCustomer = new Customer(user);
                    return customerPort.save(newCustomer);
                });
    }

}
