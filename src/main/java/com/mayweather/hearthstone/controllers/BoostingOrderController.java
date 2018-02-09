package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.BoostingOrder;
import com.mayweather.hearthstone.services.BoosterService;
import com.mayweather.hearthstone.services.BoostingOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boost")
@AllArgsConstructor
public class BoostingOrderController {

    private final BoostingOrderService boostingOrderService;


    @PostMapping("/cost")
    public ResponseEntity<Double> getCost(@RequestBody final int fromRank, final int toRank , Long id) {
        double cost = boostingOrderService.getCost(fromRank, toRank , id);
        return new ResponseEntity<>(cost, HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<BoostingOrder>> getAll(final Pageable pageable){
        Page<BoostingOrder> orders = boostingOrderService.findAll(pageable);
        return new ResponseEntity<>(orders , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BoostingOrder> findById(@PathVariable("id")final Long id){
        BoostingOrder order = boostingOrderService.findById(id);
        return new ResponseEntity<>(order , HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<BoostingOrder> create(@RequestBody final int fromRank , final int toRank){
        BoostingOrder boostingOrder = new BoostingOrder();
        boostingOrder.setFromRank(fromRank);
        boostingOrder.setToRank(toRank);
        boostingOrderService.save(boostingOrder);
        return new ResponseEntity<>(boostingOrder , HttpStatus.OK);
    }
 }
