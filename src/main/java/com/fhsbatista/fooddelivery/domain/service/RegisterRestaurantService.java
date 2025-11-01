package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterRestaurantService {
    private final RestaurantRepository repository;
    private final CuisineRepository cuisineRepository;

    public RegisterRestaurantService(
            final RestaurantRepository repository,
            final CuisineRepository cuisineRepository
    ) {
        this.repository = repository;
        this.cuisineRepository = cuisineRepository;
    }

    public Restaurant save(final Restaurant restaurant) {
        final var cuisine = cuisineRepository.findById(restaurant.getCuisine().getId());

        if (cuisine == null) {
            throw new EntityNotFoundException();
        }

        return repository.save(restaurant);
    }
}
