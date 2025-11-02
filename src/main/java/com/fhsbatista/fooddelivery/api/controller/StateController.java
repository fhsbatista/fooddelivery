package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.exceptions.EntityInUseException;
import com.fhsbatista.fooddelivery.domain.exceptions.EntityNotFoundException;
import com.fhsbatista.fooddelivery.domain.model.State;
import com.fhsbatista.fooddelivery.domain.repository.StateRepository;
import com.fhsbatista.fooddelivery.domain.service.DeleteStateService;
import com.fhsbatista.fooddelivery.domain.service.RegisterStateService;
import com.fhsbatista.fooddelivery.domain.service.UpdateStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private StateRepository repository;

    @Autowired
    private RegisterStateService registerStateService;

    @Autowired
    private DeleteStateService deleteStateService;

    @Autowired
    private UpdateStateService updateStateService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    List<State> list() {
        return repository.list();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    ResponseEntity<State> find(@PathVariable("id") Long id) {
        final var state = repository.findById(id);

        if (state == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(state);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public State create(@RequestBody State state) {
        return registerStateService.save(state);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State state) {
        try {
            final var updatedState = updateStateService.update(id, state);
            return ResponseEntity.ok(updatedState);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<State> delete(@PathVariable Long id) {
        try {
            deleteStateService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (EntityInUseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
