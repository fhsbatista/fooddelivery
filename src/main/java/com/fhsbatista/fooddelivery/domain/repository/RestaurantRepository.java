package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> list();
    Restaurant findById(Long id);
    Restaurant save(Restaurant restaurant);
    Restaurant update(Restaurant restaurant);
    void delete(Restaurant restaurant);
}
