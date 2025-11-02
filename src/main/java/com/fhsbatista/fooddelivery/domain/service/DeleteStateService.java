package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class DeleteStateService {
    private final StateRepository repository;

    public DeleteStateService(final StateRepository repository) {
        this.repository = repository;
    }

    public void delete(Long id) {
        try {
            final var state = repository.findById(id);

            if (state == null) {
                throw new EntityNotFoundException();
            }
            repository.delete(state);
        } catch (DataIntegrityViolationException e) {
            throw new EntityInUseException();
        }
    }
}

