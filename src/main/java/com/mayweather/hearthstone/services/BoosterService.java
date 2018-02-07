package com.mayweather.hearthstone.services;


import com.mayweather.hearthstone.domain.Booster;

import java.util.Optional;

public interface BoosterService {
    void save(Booster booster);
    Optional<Booster> findById(Long id);
}
