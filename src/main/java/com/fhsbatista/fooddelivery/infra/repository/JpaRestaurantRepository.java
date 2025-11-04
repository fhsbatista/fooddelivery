package com.fhsbatista.fooddelivery.infra.repository;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class JpaRestaurantRepository implements RestaurantRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> list() {
        TypedQuery<Restaurant> query = manager.createQuery("from Restaurant", Restaurant.class);
        return query.getResultList();
    }

    @Override
    public Restaurant findById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    @Transactional
    public Restaurant update(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Override
    @Transactional
    public void delete(Restaurant restaurant) {
        restaurant = findById(restaurant.getId());
        manager.remove(restaurant);
    }
}
