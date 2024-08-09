package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.order.Customer;

import java.util.Optional;

public interface CustomerPort {

    Optional<Customer> findById(Integer id);

    Customer save(Customer customer);
}
