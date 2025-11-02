package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.City;
import com.fhsbatista.fooddelivery.domain.repository.CityRepository;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCityService {
    private final CityRepository repository;
    private final StateRepository stateRepository;

    public RegisterCityService(
            final CityRepository repository,
            final StateRepository stateRepository
    ) {
        this.repository = repository;
        this.stateRepository = stateRepository;
    }

    public City save(final City city) {
        final var state = stateRepository.findById(city.getState().getId());

        if (state == null) {
            throw new EntityNotFoundException();
        }

        return repository.save(city);
    }
}

