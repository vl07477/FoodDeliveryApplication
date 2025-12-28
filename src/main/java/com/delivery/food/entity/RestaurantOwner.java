package com.delivery.food.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "restaurant_owners")
@Data
public class RestaurantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String phone;
}
