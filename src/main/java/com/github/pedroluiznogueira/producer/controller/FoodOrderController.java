package com.github.pedroluiznogueira.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pedroluiznogueira.producer.domain.FoodOrder;
import com.github.pedroluiznogueira.producer.service.FoodOrderService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/order")
public class FoodOrderController {

    private final FoodOrderService foodOrderService;

    @Autowired
    public FoodOrderController(FoodOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        System.out.println("create food order request received");
        return foodOrderService.createFoodOrder(foodOrder);
    }
}
