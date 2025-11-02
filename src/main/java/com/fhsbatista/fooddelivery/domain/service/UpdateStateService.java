package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.State;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UpdateStateService {
    private final StateRepository repository;

    public UpdateStateService(final StateRepository repository) {
        this.repository = repository;
    }

    public State update(Long id, State state) {
        final var currentState = repository.findById(id);

        if (currentState == null) {
            throw new EntityNotFoundException();
        }

        BeanUtils.copyProperties(state, currentState, "id");
        return repository.save(currentState);
    }
}

