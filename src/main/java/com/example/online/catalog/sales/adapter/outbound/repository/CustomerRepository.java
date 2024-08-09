package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
