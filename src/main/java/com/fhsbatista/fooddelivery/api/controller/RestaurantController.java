package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository repository;

    public RestaurantController(final RestaurantRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurant> list() {
        return repository.list();
    }
}
