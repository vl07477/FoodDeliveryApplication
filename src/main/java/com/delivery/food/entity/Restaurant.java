package com.delivery.food.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private RestaurantOwner owner;

    private String address;
    private String phone;
    private BigDecimal rating;
    @Column(name = "is_active")
    private Boolean active;
}
