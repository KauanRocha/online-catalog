package com.example.online.catalog.sales.application.core.usecase;

import com.example.online.catalog.sales.application.core.domain.PaymentException;
import com.example.online.catalog.sales.application.core.domain.order.Order;
import com.example.online.catalog.sales.application.port.in.OrderServicePort;
import com.example.online.catalog.sales.application.port.out.OrderPort;
import com.example.online.catalog.sales.application.port.out.PaymentPort;

public class OrderUseCase implements OrderServicePort {

    private final OrderPort orderPort;

    public final PaymentPort paymentPort;

    public OrderUseCase(OrderPort orderPort, PaymentPort paymentPort) {
        this.orderPort = orderPort;
        this.paymentPort = paymentPort;
    }

    @Override
    public Order create(Order order) {
        try {
            paymentPort.processPayment(order.getBilling().getTransactions());
        } catch (Exception e) {
            throw new PaymentException();
        }
        return orderPort.save(order);
    }

    @Override
    public Order cancel(Order order) {
        try {
            paymentPort.processRefund(order.getBilling().getTransactions());
        } catch (Exception e) {
            throw new PaymentException();
        }
        return null;
    }

}
