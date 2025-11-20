package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.infra.repository.RestaurantRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RestaurantRepository extends
        JpaRepository<Restaurant, Long>,
        RestaurantRepositoryQueries,
        JpaSpecificationExecutor<Restaurant> {
}
