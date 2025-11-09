package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UpdateCuisineService {
    private final CuisineRepository repository;

    public UpdateCuisineService(final CuisineRepository repository) {
        this.repository = repository;
    }

    public Cuisine update(Long id, Cuisine cuisine) {
        final var currentCuisine = repository.findById(id).orElseThrow(EntityNotFoundException::new);

        BeanUtils.copyProperties(cuisine, currentCuisine, "id");
        return repository.save(currentCuisine);
    }
}
