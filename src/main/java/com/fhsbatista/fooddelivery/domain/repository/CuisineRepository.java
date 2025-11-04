package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;

import java.util.List;

public interface CuisineRepository {
    List<Cuisine> list();
    List<Cuisine> listByName(String name);
    Cuisine findById(Long id);
    Cuisine save(Cuisine cuisine);
    Cuisine update(Cuisine cuisine);
    void delete(Cuisine cuisine);
}
