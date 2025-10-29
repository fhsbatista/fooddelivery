package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.service.DeleteCuisineService;
import com.fhsbatista.fooddelivery.domain.service.RegisterCuisineService;
import com.fhsbatista.fooddelivery.domain.service.UpdateCuisineService;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private RegisterCuisineService registerCuisineService;

    @Autowired
    private DeleteCuisineService deleteCuisineService;

    @Autowired
    private UpdateCuisineService updateCuisineService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<Cuisine> list() {
        return repository.list();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<Cuisine> find(@PathVariable("id") Long id) {
        final var cuisine = repository.findById(id);

        if (cuisine == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cuisine);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cuisine create(@RequestBody Cuisine cuisine) {
        return repository.save(cuisine);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<Cuisine> update(@PathVariable Long id, @RequestBody Cuisine cuisine) {
        try {
            final var updatedCuisine = updateCuisineService.update(id, cuisine);
            return ResponseEntity.ok(updatedCuisine);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cuisine> delete(@PathVariable Long id) {
        try {
            deleteCuisineService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
