package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.adapter.converters.CartConverter;
import com.example.online.catalog.sales.adapter.outbound.repository.CartRepository;
import com.example.online.catalog.sales.application.core.domain.order.Cart;
import com.example.online.catalog.sales.application.port.out.CartPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.online.catalog.sales.adapter.converters.CartConverter.process;


@Service
public class CartAdapter implements CartPort {

    private final CartRepository cartRepository;

    public CartAdapter(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Optional<Cart> getLastCartByCustomerId(Integer customerId) {
        return cartRepository.findLastCartByCustomerId(customerId)
                .map(CartConverter::convertToDomain);
    }

    @Override
    public Cart save(Cart domainCart) {
        return process(domainCart, cartRepository::save);
    }

    @Override
    public Optional<Cart> getLastCartByCustomerIdAndCreatedAtAfterOrderByCreatedAtDesc(Integer id) {
        final var thirtyMinutesAgo = LocalDateTime.now().minusMinutes(30L);
        return cartRepository.findMostRecentCartByCustomerIdWithinTimeFrame(id, thirtyMinutesAgo)
                .map(CartConverter::convertToDomain);
    }
}
