//package com.delivery.food.controller;
//
//import com.delivery.food.dto.response.DishResponse;
//import com.delivery.food.service.DishService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/dishes")
//@RequiredArgsConstructor
//@PreAuthorize("isAuthenticated()")
//public class DishController {
//
//    private final DishService dishService;
//
//    @GetMapping
//    @PreAuthorize("hasRole('admin')")
//    public ResponseEntity<List<DishResponse>> getAllDishes() {
//        return ResponseEntity.ok(dishService.getAllDishes());
//    }
//}
