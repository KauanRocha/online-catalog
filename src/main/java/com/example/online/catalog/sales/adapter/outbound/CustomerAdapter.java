package com.example.online.catalog.sales.adapter.outbound;

import com.example.online.catalog.sales.adapter.converters.CustomerConverter;
import com.example.online.catalog.sales.adapter.outbound.repository.CustomerRepository;
import com.example.online.catalog.sales.application.core.domain.order.Customer;
import com.example.online.catalog.sales.application.port.out.CustomerPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.online.catalog.sales.adapter.converters.CustomerConverter.process;

@Service
public class CustomerAdapter implements CustomerPort {

    private final CustomerRepository customerRepository;

    public CustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id).map(CustomerConverter::convertToDomain);
    }

    @Override
    public Customer save(Customer customer) {
        return process(customer, customerRepository::save);
    }
}
