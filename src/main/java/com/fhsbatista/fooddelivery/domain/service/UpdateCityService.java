package com.fhsbatista.fooddelivery.domain.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.City;
import com.fhsbatista.fooddelivery.domain.repository.CityRepository;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;

@Service
public class UpdateCityService {
    private final CityRepository cityRepository;
    private final StateRepository stateRepository;

    public UpdateCityService(
            CityRepository cityRepository,
            StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public City update(Long id, City city) {
        final var state = stateRepository.findById(city.getState().getId());
        if (state == null) {
            throw new EntityNotFoundException();
        }

        final var currentCity = cityRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        BeanUtils.copyProperties(city, currentCity, "id");
        return cityRepository.save(currentCity);
    }
}
