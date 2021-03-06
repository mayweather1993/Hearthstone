package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.services.BoosterService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/boosters")
public class BoosterController {

    private final BoosterService boosterService;


    @PostMapping
    public ResponseEntity<Booster> save(@RequestBody final Booster booster) {
        boosterService.save(booster);
        return new ResponseEntity<>(booster ,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booster> findById(@PathVariable("id") final Long id) {
        Booster booster = boosterService.findById(id);
        return new ResponseEntity<>(booster, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Booster>> findAll(Pageable pageable) {
        Page<Booster> boosterPage = boosterService.findAll(pageable);
        return new ResponseEntity<>(boosterPage, HttpStatus.OK);
    }

    @PostMapping("/{booster_id}/add_boosting_order/{boosting_order_id}")
    public ResponseEntity<Booster> addBoostingOrder(@PathVariable("booster_id") final Long booster_id,
                                                    @PathVariable("boosting_order_id") final Long boosting_order_id) {
        Booster booster = boosterService.addBoostingOrderToBooster(booster_id, boosting_order_id);
        boosterService.save(booster);
        return new ResponseEntity<>(booster , HttpStatus.OK);
    }
    @PostMapping("/booster/{booster_id}/add_arena_order/{arena_order_id}")
    public ResponseEntity<Booster> addArenaOrder(@PathVariable("booster_id") final Long booster_id,
                                                 @PathVariable("arena_order_id") final Long arena_order_id){
        Booster booster = boosterService.addArenaOrderToBooster(booster_id, arena_order_id);
        boosterService.save(booster);
        return new ResponseEntity<>(booster , HttpStatus.OK);
    }
    @PutMapping("/update_salary/{id}")
    public ResponseEntity<Booster> put(@PathVariable("id") final Long id , int salary){
        boosterService.setSalaryToBooster(id , salary);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
