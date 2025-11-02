package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.repository.CityRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteCityService {
    private final CityRepository repository;

    public DeleteCityService(final CityRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        try {
            final var city = repository.findById(id);

            if (city == null) {
                throw new EntityNotFoundException();
            }
            repository.delete(city);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException();
        }
    }
}

