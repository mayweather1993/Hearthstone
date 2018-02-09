package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.ArenaOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArenaOrderService {
    void save(ArenaOrder arenaOrder);

    ArenaOrder findById(Long id);

    Page<ArenaOrder> findAll(Pageable pageable);

    double getCostForArenaBoosting(int wins, int salary);
}
