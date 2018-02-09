package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.data.BoosterRepository;
import com.mayweather.hearthstone.domain.ArenaOrder;
import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.BoostingOrder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class BoosterServiceImpl implements BoosterService {

    private final BoosterRepository boosterRepository;
    private final BoostingOrderService boostingOrderService;
    private final ArenaOrderService arenaOrderService;

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
    public Booster addBoostingOrderToBooster(Long boosting_order_id, Long booster_id) {
        BoostingOrder order = boostingOrderService.findById(boosting_order_id);
        boostingOrderService.save(order);
        Booster booster = boosterRepository.getOne(booster_id);
        booster.setBoostingOrderList(Arrays.asList(order));
        return boosterRepository.save(booster);
    }

    @Override
    public Booster addArenaOrderToBooster(Long booster_id, Long arena_order_id) {
        ArenaOrder order = arenaOrderService.findById(arena_order_id);
        arenaOrderService.save(order);
        Booster booster = boosterRepository.getOne(booster_id);
        booster.setArenaOrderList(Arrays.asList(order));
        return boosterRepository.save(booster);
    }

    @Override
    public void setSalaryToBooster(Long id , int salary) {
        Booster booster = boosterRepository.getOne(id);
        booster.setSalary(salary);
        boosterRepository.save(booster);
    }

}
