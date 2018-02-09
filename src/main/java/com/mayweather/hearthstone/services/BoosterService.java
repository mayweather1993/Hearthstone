package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.Booster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoosterService {
    void save(Booster booster);

    Booster findById(Long id);

    Page<Booster> findAll(Pageable pageable);

    Booster addBoostingOrderToBooster(Long booster_id, Long boosting_order_id);

    Booster addArenaOrderToBooster(Long booster_id, Long arena_order_id);

    void setSalaryToBooster(Long id , int salary);
}
