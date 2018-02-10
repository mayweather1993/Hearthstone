package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.ArenaOrderRepository;
import com.mayweather.hearthstone.domain.ArenaOrder;
import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.exceptions.DuplicateException;
import com.mayweather.hearthstone.exceptions.NoSuchArenaOrderException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArenaOrderServiceImpl implements ArenaOrderService {

    private final ArenaOrderRepository arenaOrderRepository;
    private final BoosterService boosterService;

    @Override
    public void save(ArenaOrder arenaOrder) {
        arenaOrderRepository.save(arenaOrder);
    }

    @Override
    public ArenaOrder findById(Long id) {
        if (!arenaOrderRepository.existsById(id)) {
            throw new NoSuchArenaOrderException("No such arena order with id : " + id);
        }
        return arenaOrderRepository.getOne(id);
    }

    @Override
    public Page<ArenaOrder> findAll(Pageable pageable) {
        return arenaOrderRepository.findAll(pageable);
    }

    @Override
    public double getCostForArenaBoosting(int wins, Long id) {
        Booster booster = boosterService.findById(id);
        int boosterSalary = booster.getSalary();
        return (double) wins * boosterSalary;
    }
}
