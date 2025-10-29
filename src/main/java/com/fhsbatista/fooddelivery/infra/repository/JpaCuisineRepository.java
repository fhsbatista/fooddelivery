package com.fhsbatista.fooddelivery.infra.repository;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JpaCuisineRepository implements CuisineRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cuisine findById(Long id) {
        return entityManager.find(Cuisine.class, id);
    }

    @Override
    public List<Cuisine> list() {
        TypedQuery<Cuisine> query = entityManager.createQuery("from Cuisine", Cuisine.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Cuisine save(Cuisine cuisine) {
        return entityManager.merge(cuisine);
    }

    @Override
    @Transactional
    public Cuisine update(Cuisine cuisine) {
        return entityManager.merge(cuisine);
    }

    @Override
    @Transactional
    public void delete(Cuisine cuisine) {
        cuisine = findById(cuisine.getId());

        if (cuisine == null) {
            throw new EmptyResultDataAccessException(1);
        }

        entityManager.remove(cuisine);
    }
}
