package com.example.online.catalog.sales.application.core.domain;

import com.example.online.catalog.sales.application.core.domain.enums.OrderStatusEnum;
import com.example.online.catalog.sales.application.core.domain.enums.PaymentMethodEnum;

import java.math.BigDecimal;

public class Transaction {

    private Integer id;

    private OrderStatusEnum status;

    private PaymentMethodEnum paymentMethod;

    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
