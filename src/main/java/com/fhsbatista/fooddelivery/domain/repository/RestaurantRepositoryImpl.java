package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestaurantRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Restaurant> findAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax) {
        final var jpql = "from Restaurant where name like :name " +
                "and deliveryTax between :initialDeliveryTax and :finalDeliveryTax";

        return entityManager.createQuery(jpql, Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("initialDeliveryTax", initialDeliveryTax)
                .setParameter("finalDeliveryTax", finalDeliveryTax)
                .getResultList();
    }
}
