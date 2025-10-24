package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
    @Autowired
    private CuisineRepository repository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Cuisine> list() {
        return repository.list();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    ResponseEntity<Cuisine> find(@PathVariable("id") Long id) {
        final var cuisine = repository.findById(id);

        if (cuisine == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cuisine);
    }
}
