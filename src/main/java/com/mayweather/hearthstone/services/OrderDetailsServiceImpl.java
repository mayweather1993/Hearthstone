package com.mayweather.hearthstone.services;

import com.mayweather.hearthstone.data.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public double getCost(int fromRank, int toRank, int salaryPerHour) {
        return (double) ((fromRank - toRank) * salaryPerHour);
    }
}
