package com.delivery.food.dto.request;

import java.math.BigDecimal;

public class OrderDishItem {
    private Long dishId;
    private Integer quantity;
    private BigDecimal price;

    // Конструкторы
    public OrderDishItem() {}

    public OrderDishItem(Long dishId, Integer quantity, BigDecimal price) {
        this.dishId = dishId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters/Setters
    public Long getDishId() { return dishId; }
    public void setDishId(Long dishId) { this.dishId = dishId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
