package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterCuisine {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Cuisine> list() {
        TypedQuery<Cuisine> query = entityManager.createQuery("from Cuisine", Cuisine.class);
        return query.getResultList();
    }
}
