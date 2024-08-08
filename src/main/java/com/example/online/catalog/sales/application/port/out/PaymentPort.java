package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.order.Transaction;

import java.util.List;

public interface PaymentPort {

    void processPayment(List<Transaction> transactions);

    void processRefund(List<Transaction> transactions);
}
