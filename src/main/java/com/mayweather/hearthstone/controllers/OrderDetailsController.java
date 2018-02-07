package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.services.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cost")
@AllArgsConstructor
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;


    @PostMapping
    public ResponseEntity getCost(@RequestBody final int fromRank ,final int toRank ,final int salaryPerRank){
        double cost = orderDetailsService.getCost(fromRank, toRank, salaryPerRank);
        return  new ResponseEntity(cost,HttpStatus.OK);
    }
}
