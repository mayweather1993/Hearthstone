package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public double getCost(final int fromRank,final int toRank,final int salaryPerHour) {
        return (double) ((fromRank - toRank) * salaryPerHour);
    }
}
