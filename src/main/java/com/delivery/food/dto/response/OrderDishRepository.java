package com.delivery.food.repository;

import com.delivery.food.entity.OrderDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDishRepository extends JpaRepository<OrderDish, Long> {
}
