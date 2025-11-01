package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UpdateRestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final CuisineRepository cuisineRepository;

    public UpdateRestaurantService(
            RestaurantRepository restaurantRepository,
            CuisineRepository cuisineRepository
    ) {
        this.restaurantRepository = restaurantRepository;
        this.cuisineRepository = cuisineRepository;
    }

    public Restaurant update(Restaurant restaurant) {
        final var cuisine = cuisineRepository.findById(restaurant.getCuisine().getId());
        if (cuisine == null) {
            throw new EntityNotFoundException();
        }

        final var currentRestaurant = restaurantRepository.findById(restaurant.getId());
        if (currentRestaurant == null) {
            throw new EntityNotFoundException();
        }

        BeanUtils.copyProperties(restaurant, currentRestaurant, "id");
        restaurantRepository.save(currentRestaurant);
        return currentRestaurant;
    }

}
