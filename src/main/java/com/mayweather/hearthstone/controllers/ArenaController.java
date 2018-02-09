package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.services.ArenaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/arena")
public class ArenaController {

    private final ArenaService arenaService;

    @PostMapping()
    public ResponseEntity<Double> getCostForArenaBoosting(@RequestBody int wins , int salary){
        double costForArenaBoosting = arenaService.getCostForArenaBoosting(wins, salary);
        return new ResponseEntity<>(costForArenaBoosting,HttpStatus.OK);
    }
}
