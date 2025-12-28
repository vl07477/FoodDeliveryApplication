package com.delivery.food.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateOrderRequest {
    @NotNull
    private Long restaurantId;

    @NotEmpty
    private List<OrderDishItem> items;  // ✅ Правильный импорт (в том же пакете)

    private String deliveryAddress;

    // getters/setters
    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
    public List<OrderDishItem> getItems() { return items; }
    public void setItems(List<OrderDishItem> items) { this.items = items; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }
}
