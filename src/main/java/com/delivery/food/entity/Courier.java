package com.delivery.food.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "couriers")
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String phone;
    private String vehicleType;
    private String status;
}
