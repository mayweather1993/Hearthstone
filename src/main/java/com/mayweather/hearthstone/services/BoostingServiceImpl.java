package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.data.BoosterRepository;
import com.mayweather.hearthstone.domain.Booster;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BoostingServiceImpl implements BoosterService {

    private final BoosterRepository boosterRepository;

    @Override
    public void save(final Booster booster) {
        boosterRepository.save(booster);
    }

    @Override
    public Optional<Booster> findById(final Long id) {
        return boosterRepository.findById(id);
    }
}
