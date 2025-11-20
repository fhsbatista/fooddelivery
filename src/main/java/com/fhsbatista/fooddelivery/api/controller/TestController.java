package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

import static com.fhsbatista.fooddelivery.infra.repository.specification.RestaurantSpecs.freeDelivery;
import static com.fhsbatista.fooddelivery.infra.repository.specification.RestaurantSpecs.similarName;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/restaurants/find")
    List<Restaurant> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BigDecimal initialDeliveryTax,
            @RequestParam(required = false) BigDecimal finalDeliveryTax) {
        return restaurantRepository.criteriaApiFindAll(name, initialDeliveryTax, finalDeliveryTax);
    }

    @GetMapping("/restaurants/free-delivery")
    List<Restaurant> findFreeDelivery(@RequestParam String name) {
        return restaurantRepository.findAll(freeDelivery().and(similarName(name)));
    }

}
