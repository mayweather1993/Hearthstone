package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.ArenaOrderRepository;
import com.mayweather.hearthstone.domain.ArenaOrder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArenaOrderServiceImpl implements ArenaOrderService {

    private final ArenaOrderRepository arenaOrderRepository;

    @Override
    public void save(ArenaOrder arenaOrder) {
        arenaOrderRepository.save(arenaOrder);
    }

    @Override
    public ArenaOrder findById(Long id) {
        return arenaOrderRepository.getOne(id);
    }

    @Override
    public Page<ArenaOrder> findAll(Pageable pageable) {
        return arenaOrderRepository.findAll(pageable);
    }

    @Override
    public double getCostForArenaBoosting(int wins, int salary) {
        return (double) wins * salary;
    }
}
