package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.data.BoosterRepository;
import com.mayweather.hearthstone.domain.Booster;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoostingServiceImpl implements BoosterService {

    private final BoosterRepository boosterRepository;

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

}
