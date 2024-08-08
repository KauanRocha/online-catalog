package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.catalog.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
