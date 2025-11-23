package com.fhsbatista.fooddelivery.infra.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;

import java.math.BigDecimal;
import java.util.List;

public interface RestaurantRepositoryQueries {
    List<Restaurant> findAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax);
    List<Restaurant> dynamicFindAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax);
    List<Restaurant> criteriaApiFindAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax);
    List<Restaurant> findAllFreeDelivery(String name);
}
