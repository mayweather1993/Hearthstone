package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.OrderRepository;
import com.mayweather.hearthstone.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(final Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Page<Order> getAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }
}
