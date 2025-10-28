package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCuisineService {
    private final CuisineRepository repository;

    public RegisterCuisineService(final CuisineRepository repository) {
        this.repository = repository;
    }

    public Cuisine save(final Cuisine cuisine) {
        return repository.save(cuisine);
    }
}
