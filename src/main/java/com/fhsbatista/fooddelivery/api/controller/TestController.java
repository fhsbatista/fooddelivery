package com.fhsbatista.fooddelivery.api.controller;

import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import com.fhsbatista.fooddelivery.infra.repository.specification.RestaurantFreeDeliverySpec;
import com.fhsbatista.fooddelivery.infra.repository.specification.RestaurantSimilarNameSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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
        final var freeDeliveryRestaurants = new RestaurantFreeDeliverySpec();
        final var similarNameRestaurants = new RestaurantSimilarNameSpec(name);
        return restaurantRepository.findAll(freeDeliveryRestaurants.and(similarNameRestaurants));
    }

}
