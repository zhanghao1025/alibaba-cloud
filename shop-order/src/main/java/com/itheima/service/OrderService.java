package com.itheima.service;

import com.itheima.domain.Order;

public interface OrderService {
    Order createOrder(Order order);

    String getMessage();
}
