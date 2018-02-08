package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.data.BoosterRepository;
import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class BoostingServiceImpl implements BoosterService {

    private final BoosterRepository boosterRepository;
    private final OrderService orderService;

    @Override
    public void save(final Booster booster) {
        boosterRepository.save(booster);
    }

    @Override
    public Booster findById(final Long id) {
        return boosterRepository.getOne(id);
    }

    @Override
    public Page<Booster> findAll(Pageable pageable) {
        return boosterRepository.findAll(pageable);
    }

    @Override
    public Booster addOrderToBooster(Long order_id , Long booster_id) {
        Order order = orderService.findById(order_id);
        orderService.save(order);
        Booster booster = boosterRepository.getOne(booster_id);
        booster.setOrderList(Arrays.asList(order));
        return boosterRepository.save(booster);
    }
}
