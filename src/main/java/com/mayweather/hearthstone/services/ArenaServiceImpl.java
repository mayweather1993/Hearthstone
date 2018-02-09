package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.ArenaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArenaServiceImpl implements ArenaService {

    private final ArenaRepository arenaRepository;

    @Override
    public double getCostForArenaBoosting(int wins, int salary) {
        return (double) wins * salary;
    }
}
