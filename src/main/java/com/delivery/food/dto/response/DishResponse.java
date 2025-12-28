package com.delivery.food.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DishResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private Boolean available;
}
