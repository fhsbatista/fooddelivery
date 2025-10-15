package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
    @Autowired
    private CuisineRepository repository;

    @GetMapping
    List<Cuisine> list() {
        return repository.list();
    }
}
