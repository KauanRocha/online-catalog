package com.example.online.catalog.sales.application.port.in;

import com.example.online.catalog.sales.application.core.domain.order.Order;

public interface OrderServicePort {

    Order create(Order order);

    Order cancel(Order order);
}
