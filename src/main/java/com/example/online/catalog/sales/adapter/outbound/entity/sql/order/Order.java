package com.example.online.catalog.sales.adapter.outbound.entity.sql.order;


import com.example.online.catalog.sales.application.core.domain.order.OrderStatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;

    @OneToOne(fetch = FetchType.EAGER)
    private Transaction transaction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transction) {
        this.transaction = transction;
    }
}
