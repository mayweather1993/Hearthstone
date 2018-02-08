package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    void save(Order order);
    Order findById(Long id);
    Page<Order> getAll(Pageable pageable);
}
