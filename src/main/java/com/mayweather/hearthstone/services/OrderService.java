package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.domain.Order;

public interface OrderService {
    void save(Order order);
    Order findById(Long id);
}
