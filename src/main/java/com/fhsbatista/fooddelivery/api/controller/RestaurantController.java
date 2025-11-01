package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import com.fhsbatista.fooddelivery.domain.service.RegisterRestaurantService;
import com.fhsbatista.fooddelivery.domain.service.UpdateRestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return repository.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> find(@PathVariable Long id) {
        final var restaurant = repository.findById(id);

        if (restaurant == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(restaurant);
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
}
