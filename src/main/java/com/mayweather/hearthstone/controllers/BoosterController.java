package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.Booster;
import com.mayweather.hearthstone.services.BoosterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<Booster> findById(@PathVariable("id")final Long id){
        Optional<Booster> booster = boosterService.findById(id);
        return new ResponseEntity<Booster>(HttpStatus.OK);
    }
}
