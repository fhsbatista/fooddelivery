package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.City;
import com.fhsbatista.fooddelivery.domain.repository.CityRepository;
import com.fhsbatista.fooddelivery.domain.service.DeleteCityService;
import com.fhsbatista.fooddelivery.domain.service.RegisterCityService;
import com.fhsbatista.fooddelivery.domain.service.UpdateCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityRepository repository;

    @Autowired
    private RegisterCityService registerCityService;

    @Autowired
    private DeleteCityService deleteCityService;

    @Autowired
    private UpdateCityService updateCityService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<City> list() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<City> find(@PathVariable("id") Long id) {
        final var city = repository.findById(id);
        return city.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<City> create(@RequestBody City city) {
        try {
            final var persisted = registerCityService.save(city);
            return ResponseEntity.status(HttpStatus.CREATED).body(persisted);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
        try {
            final var updatedCity = updateCityService.update(id, city);
            return ResponseEntity.ok(updatedCity);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id) {
        try {
            deleteCityService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

