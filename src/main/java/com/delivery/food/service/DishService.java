package com.delivery.food.service;

import com.delivery.food.dto.response.DishResponse;
import com.delivery.food.entity.Dish;
import com.delivery.food.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;

    public List<DishResponse> getDishesByRestaurantId(Long restaurantId) {
        return dishRepository.findByRestaurantId(restaurantId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private DishResponse mapToResponse(Dish dish) {
        return new DishResponse(
                dish.getId(),
                dish.getName(),
                dish.getDescription(),
                dish.getPrice(),
                dish.getCategory(),
                dish.getAvailable()
        );
    }
}
