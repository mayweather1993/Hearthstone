package com.mayweather.hearthstone.controllers;

import com.mayweather.hearthstone.domain.Order;
import com.mayweather.hearthstone.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity save(@RequestBody final Order order){
        orderService.save(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> findById(@PathVariable("id")final Long id){
        Order order = orderService.findById(id);
        return new ResponseEntity<Order>(order , HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<Page<Order>> getAll(Pageable pageable){
        Page<Order> orders = orderService.getAll(pageable);
        return new ResponseEntity<>(orders , HttpStatus.OK);
    }


}
