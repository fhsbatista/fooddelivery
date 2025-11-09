package com.fhsbatista.fooddelivery.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import com.fhsbatista.fooddelivery.domain.service.RegisterRestaurantService;
import com.fhsbatista.fooddelivery.domain.service.UpdateRestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RegisterRestaurantService registerRestaurantService;
    private final UpdateRestaurantService updateRestaurantService;
    private final RestaurantRepository repository;
    private final CuisineRepository cuisineRepository;

    public RestaurantController(
            final RegisterRestaurantService registerRestaurantService,
            final UpdateRestaurantService updateRestaurantService,
            final RestaurantRepository repository,
            final CuisineRepository cuisineRepository) {
        this.registerRestaurantService = registerRestaurantService;
        this.updateRestaurantService = updateRestaurantService;
        this.repository = repository;
        this.cuisineRepository = cuisineRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> list() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> find(@PathVariable Long id) {
        final var restaurant = repository.findById(id);
        return restaurant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant) {
        try {
            final var persisted = registerRestaurantService.save(restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body(persisted);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@RequestBody Restaurant restaurant) {
        try {
            final var persisted = updateRestaurantService.update(restaurant);
            return ResponseEntity.ok(persisted);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Restaurant> patch(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        final var maybeRestaurant = repository.findById(id);

        if (maybeRestaurant.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        final var restaurant = maybeRestaurant.get();

        final var objectMapper = new ObjectMapper();

        fields.forEach((key, value) -> {
            final Field field = ReflectionUtils.findField(Restaurant.class, key);
            field.setAccessible(true);

            final var newValue = objectMapper.convertValue(value, field.getType());
            ReflectionUtils.setField(field, restaurant, newValue);
        });

        try {
            final var persisted = updateRestaurantService.update(restaurant);
            return ResponseEntity.ok(persisted);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
