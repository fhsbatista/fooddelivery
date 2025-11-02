package com.fhsbatista.fooddelivery.domain.service;

import com.fhsbatista.fooddelivery.domain.model.State;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterStateService {
    private final StateRepository repository;

    public RegisterStateService(final StateRepository repository) {
        this.repository = repository;
    }

    public State save(final State state) {
        return repository.save(state);
    }
}

