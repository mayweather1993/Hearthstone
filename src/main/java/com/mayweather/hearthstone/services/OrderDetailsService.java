package com.mayweather.hearthstone.services;

public interface OrderDetailsService {
    double getCost(int fromRank , int toRank , int salaryPerHour);
}
