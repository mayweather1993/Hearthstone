package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.BoostingOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoostingOrderService {
    void save(BoostingOrder boostingOrder);

    BoostingOrder findById(Long id);

    Page<BoostingOrder> findAll(Pageable pageable);

    double getCost(int startingRank, int endingRank, int salaryPerRank);

}
