package com.fhsbatista.fooddelivery.infra.repository.specification;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class RestaurantSimilarNameSpec implements Specification<Restaurant> {
    private final String name;

    public RestaurantSimilarNameSpec(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        return builder.like(root.get("name"), "%" + name + "%");
    }
}
