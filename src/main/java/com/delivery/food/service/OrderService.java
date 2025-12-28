package com.delivery.food.service;

import com.delivery.food.dto.request.CreateOrderRequest;
import com.delivery.food.dto.request.OrderDishItem;
import com.delivery.food.dto.response.OrderResponse;
import com.delivery.food.entity.*;
import com.delivery.food.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final DishRepository dishRepository;
    private final OrderDishRepository orderDishRepository;

    public OrderResponse createOrder(CreateOrderRequest request, Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setRestaurant(restaurant);
        order.setStatus("pending");
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setCreatedAt(LocalDateTime.now());

        BigDecimal total = calculateTotal(request.getItems());
        order.setTotalAmount(total);

        order = orderRepository.save(order);

        // Save order items
        for (OrderDishItem item : request.getItems()) {
            Dish dish = dishRepository.findById(item.getDishId())
                    .orElseThrow(() -> new RuntimeException("Dish not found"));

            OrderDish orderDish = new OrderDish();
            orderDish.setOrder(order);
            orderDish.setDish(dish);
            orderDish.setQuantity(item.getQuantity());
            orderDish.setPriceAtOrder(dish.getPrice());
            orderDishRepository.save(orderDish);
        }

        return mapToOrderResponse(order);
    }

    private BigDecimal calculateTotal(List<OrderDishItem> items) {
        return items.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private OrderResponse mapToOrderResponse(Order order) {
        OrderResponse response = new OrderResponse();
        response.setId(order.getId());
        response.setStatus(order.getStatus());
        response.setTotalAmount(order.getTotalAmount());
        response.setDeliveryAddress(order.getDeliveryAddress());
        response.setCreatedAt(order.getCreatedAt());
        return response;
    }
}
