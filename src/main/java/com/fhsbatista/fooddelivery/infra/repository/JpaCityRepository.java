package com.fhsbatista.fooddelivery.infra.repository;

import com.fhsbatista.fooddelivery.domain.model.City;
import com.fhsbatista.fooddelivery.domain.repository.CityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class JpaCityRepository implements CityRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<City> list() {
        TypedQuery<City> query = manager.createQuery("from City", City.class);
        return query.getResultList();
    }

    @Override
    public City findById(Long id) {
        return manager.find(City.class, id);
    }

    @Override
    @Transactional
    public City save(City city) {
        return manager.merge(city);
    }

    @Override
    @Transactional
    public City update(City city) {
        return manager.merge(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        city = findById(city.getId());
        manager.remove(city);
    }
}

