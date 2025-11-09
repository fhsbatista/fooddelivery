package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteCuisineService {
    private final CuisineRepository repository;

    public DeleteCuisineService(final CuisineRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        try {
            final var cuisine = repository.findById(id).orElseThrow(EntityInUseException::new);
            repository.delete(cuisine);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException();
        }
    }
}
