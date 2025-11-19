package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.infra.repository.RestaurantRepositoryQueries;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.util.StringUtils;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepositoryQueries {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurant> findAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax) {
        final var jpql = "from Restaurant where name like :name " +
                "and deliveryTax between :initialDeliveryTax and :finalDeliveryTax";

        return entityManager.createQuery(jpql, Restaurant.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("initialDeliveryTax", initialDeliveryTax)
                .setParameter("finalDeliveryTax", finalDeliveryTax)
                .getResultList();
    }

    @Override
    public List<Restaurant> dynamicFindAll(String name, BigDecimal initialDeliveryTax, BigDecimal finalDeliveryTax) {
        final var jpql = new StringBuilder();
        jpql.append("from Restaurant where 0 = 0"); // dummy predicate keeps the WHERE clause syntactically valid even if no filters are added later

        final var parameters = new HashMap<String, Object>();

        if (StringUtils.hasText(name)) {
            jpql.append(" and name like :name");
            parameters.put("name", "%" + name  + "%");
        }

        if (initialDeliveryTax != null) {
            jpql.append(" and deliveryTax >= :initialDeliveryTax");
            parameters.put("initialDeliveryTax", initialDeliveryTax);
        }

        if (finalDeliveryTax != null) {
            jpql.append(" and deliveryTax <= :finalDeliveryTax");
            parameters.put("finalDeliveryTax", finalDeliveryTax);
        }

        final var query = entityManager.createQuery(jpql.toString(), Restaurant.class);
        parameters.forEach(query::setParameter);
        return query.getResultList();
    }
}
