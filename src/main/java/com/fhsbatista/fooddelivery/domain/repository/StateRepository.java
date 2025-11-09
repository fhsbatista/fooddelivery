package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
