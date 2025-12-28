package com.delivery.food.controller;

import com.delivery.food.dto.response.DishResponse;
import com.delivery.food.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/menu")
@RequiredArgsConstructor
public class MenuController {

    private final DishService dishService;

    @GetMapping
    public ResponseEntity<List<DishResponse>> getMenu(@PathVariable Long id) {
        return ResponseEntity.ok(dishService.getDishesByRestaurantId(id));
    }
}
