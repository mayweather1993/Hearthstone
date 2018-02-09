package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoosterService {
    void save(Booster booster);

    Booster findById(Long id);

    Page<Booster> findAll(Pageable pageable);

    Booster addOrderToBooster(Long order_id, Long booster_id);

    Booster addArenaOrderToBooster(long arena_order_id , Long booster_id);
}
