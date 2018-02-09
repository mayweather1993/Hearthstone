package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.BoostingOrderRepository;
import com.mayweather.hearthstone.domain.BoostingOrder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoostingOrderServiceImpl implements BoostingOrderService {

    private final BoostingOrderRepository boostingOrderRepository;

    @Override
    public void save(BoostingOrder boostingOrder) {
        boostingOrderRepository.save(boostingOrder);
    }

    @Override
    public BoostingOrder findById(Long id) {
        return boostingOrderRepository.getOne(id);
    }

    @Override
    public Page<BoostingOrder> findAll(Pageable pageable) {
        return boostingOrderRepository.findAll(pageable);
    }

    @Override
    public double getCost(int startingRank, int endingRank, int salaryPerRank) {
        return (double) (startingRank - endingRank) * salaryPerRank;
    }
}
