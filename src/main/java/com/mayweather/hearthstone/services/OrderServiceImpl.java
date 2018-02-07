package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.OrderRepository;
import com.mayweather.hearthstone.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.getOne(id);
    }
}
