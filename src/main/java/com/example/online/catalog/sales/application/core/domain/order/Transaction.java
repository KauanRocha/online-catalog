package com.example.online.catalog.sales.application.core.domain.order;

import java.math.BigDecimal;
import java.util.Map;

public class Transaction {

    private Integer id;

    private OrderStatusEnum status;

    private PaymentMethodEnum paymentMethod;

    private BigDecimal amount;

    private Map<String, String> transactionIntegrationDetails;

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

    public Map<String, String> getTransactionIntegrationDetails() {
        return transactionIntegrationDetails;
    }

    public void setTransactionIntegrationDetails(Map<String, String> transactionIntegrationDetails) {
        this.transactionIntegrationDetails = transactionIntegrationDetails;
    }
}
