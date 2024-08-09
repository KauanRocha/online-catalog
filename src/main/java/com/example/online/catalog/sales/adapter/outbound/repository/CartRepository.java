package com.example.online.catalog.sales.adapter.outbound.repository;

import com.example.online.catalog.sales.adapter.outbound.entity.sql.order.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM SalesCart c WHERE c.customer.user.id = :customerId ORDER BY c.createdAt DESC")
    Optional<Cart> findLastCartByCustomerId(@Param("customerId") Integer customerId);

    @Query("SELECT c FROM SalesCart c WHERE c.customer.user.id = :customerId AND c.createdAt >= :startTime ORDER BY c.createdAt DESC")
    Optional<Cart> findMostRecentCartByCustomerIdWithinTimeFrame(@Param("customerId") Integer customerId, @Param("startTime") LocalDateTime startTime);
}