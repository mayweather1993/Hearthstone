package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.services.BoostingOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boost")
@AllArgsConstructor
public class BoostingOrderController {

    private final BoostingOrderService boostingOrderService;


    @PostMapping("/cost")
    public ResponseEntity<Double> getCost(@RequestBody final int fromRank, final int toRank, final int salaryPerRank) {
        double cost = boostingOrderService.getCost(fromRank, toRank, salaryPerRank);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
}
