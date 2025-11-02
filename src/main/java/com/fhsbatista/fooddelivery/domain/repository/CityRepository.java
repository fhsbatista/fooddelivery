package com.fhsbatista.fooddelivery.domain.repository;

import com.fhsbatista.fooddelivery.domain.model.City;

import java.util.List;

public interface CityRepository {
    List<City> list();
    City findById(Long id);
    City save(City city);
    City update(City city);
    void delete(City city);
}

