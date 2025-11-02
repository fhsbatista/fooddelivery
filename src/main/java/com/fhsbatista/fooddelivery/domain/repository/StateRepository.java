package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.State;

import java.util.List;

public interface StateRepository {
    List<State> list();
    State findById(Long id);
    State save(State state);
    State update(State state);
    void delete(State state);
}
