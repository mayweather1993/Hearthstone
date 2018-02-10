package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.data.BoosterRepository;
import com.mayweather.hearthstone.domain.ArenaOrder;
import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.BoostingOrder;
import com.mayweather.hearthstone.domain.Status;
import com.mayweather.hearthstone.exceptions.NoSuchBoosterException;
import com.mayweather.hearthstone.exceptions.NotAvailableBoosterException;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BoosterServiceImpl implements BoosterService {

    public BoosterServiceImpl(@Lazy BoosterRepository boosterRepository, @Lazy BoostingOrderService boostingOrderService, @Lazy ArenaOrderService arenaOrderService) {
        this.boosterRepository = boosterRepository;
        this.boostingOrderService = boostingOrderService;
        this.arenaOrderService = arenaOrderService;
    }

    private final BoosterRepository boosterRepository;
    private final BoostingOrderService boostingOrderService;
    private final ArenaOrderService arenaOrderService;

    @Override
    public void save(final Booster booster) {
        boosterRepository.save(booster);
    }

    @Override
    public Booster findById(final Long id) {
        if(!boosterRepository.existsById(id)){
            throw new NoSuchBoosterException("No such booster with id : " + id);
        }
        return boosterRepository.getOne(id);
    }

    @Override
    public Page<Booster> findAll(Pageable pageable) {
        return boosterRepository.findAll(pageable);
    }

    @Override
    public Booster addBoostingOrderToBooster(Long booster_id, Long boosting_order_id) {
        BoostingOrder order = boostingOrderService.findById(boosting_order_id);

        boostingOrderService.save(order);
        Booster booster = boosterRepository.getOne(booster_id);
        if (booster.getStatus() == Status.WORKING) {
            throw new NotAvailableBoosterException();
        } else {
            booster.setBoostingOrder(order);
            booster.setStatus(Status.WORKING);
        }
        return boosterRepository.save(booster);
    }

    @Override
    public Booster addArenaOrderToBooster(Long booster_id, Long arena_order_id) {
        Booster booster = boosterRepository.getOne(booster_id);
        ArenaOrder order = arenaOrderService.findById(arena_order_id);
        arenaOrderService.save(order);
        if (booster.getStatus() == Status.WORKING) {
            throw new NotAvailableBoosterException();
        } else {
            booster.setArenaOrder(order);
            booster.setStatus(Status.WORKING);
        }
        return boosterRepository.save(booster);
    }

    @Override
    public void setSalaryToBooster(Long id, int salary) {
        Booster booster = boosterRepository.getOne(id);
        booster.setSalary(salary);
        boosterRepository.save(booster);
    }

}
