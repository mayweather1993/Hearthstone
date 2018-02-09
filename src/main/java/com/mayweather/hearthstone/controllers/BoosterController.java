package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.domain.Order;
import com.mayweather.hearthstone.services.BoosterService;
import com.mayweather.hearthstone.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/boostingservice")
public class BoosterController {

    private final BoosterService boosterService;


    @PostMapping("/createBooster")
    public ResponseEntity save(@RequestBody final Booster booster) {
        boosterService.save(booster);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/booster/{id}")
    public ResponseEntity<Booster> findById(@PathVariable("id") final Long id) {
        Booster booster = boosterService.findById(id);
        return new ResponseEntity<>(booster, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Page<Booster>> findAll(Pageable pageable) {
        Page<Booster> boosterPage = boosterService.findAll(pageable);
        return new ResponseEntity<>(boosterPage, HttpStatus.OK);
    }

    @PostMapping("booster/{booster_id}/addOrder/{order_id}")
    public ResponseEntity<Booster> addOrder(@PathVariable("booster_id") final Long booster_id,
                                            @PathVariable("order_id") final Long order_id) {
        Booster booster = boosterService.addOrderToBooster(order_id, booster_id);
        boosterService.save(booster);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
