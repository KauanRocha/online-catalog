package com.example.online.catalog.sales.application.port.out;

import com.example.online.catalog.sales.application.core.domain.order.Order;

public interface OrderPort {

    Order save(Order order);
}
