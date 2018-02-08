package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.Booster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoosterService {
    void save(Booster booster);
    Booster findById(Long id);
    Page<Booster> findAll(Pageable pageable);
}
