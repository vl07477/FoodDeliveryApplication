package com.delivery.food.dto.response;

import java.math.BigDecimal;

public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private BigDecimal rating;

    // constructors, getters/setters
    public RestaurantResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public BigDecimal getRating() { return rating; }
    public void setRating(BigDecimal rating) { this.rating = rating; }
}
