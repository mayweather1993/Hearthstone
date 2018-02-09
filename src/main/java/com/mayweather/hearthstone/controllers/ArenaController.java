package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.ArenaOrder;
import com.mayweather.hearthstone.services.ArenaOrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/arena")
public class ArenaController {

    private final ArenaOrderService arenaOrderService;

    @PostMapping("/cost")
    public ResponseEntity<Double> getCostForArenaBoosting(@RequestBody int wins , int salary){
        double costForArenaBoosting = arenaOrderService.getCostForArenaBoosting(wins, salary);
        return new ResponseEntity<>(costForArenaBoosting,HttpStatus.OK);
    }
    @GetMapping("/getAllArenaOrders")
    public ResponseEntity<Page<ArenaOrder>> getAll(Pageable pageable){
        Page<ArenaOrder> arenaOrders = arenaOrderService.findAll(pageable);
        return new ResponseEntity<>(arenaOrders , HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArenaOrder> findById(@PathVariable("id") Long id){
        ArenaOrder arenaOrder = arenaOrderService.findById(id);
        return new ResponseEntity<>(arenaOrder,HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody int wins, int salary){
        ArenaOrder arenaOrder = new ArenaOrder();
        arenaOrder.setWins(wins);
        arenaOrder.setSalary(salary);
        arenaOrderService.save(arenaOrder);
        return new ResponseEntity<>(arenaOrder , HttpStatus.OK);
    }
}
