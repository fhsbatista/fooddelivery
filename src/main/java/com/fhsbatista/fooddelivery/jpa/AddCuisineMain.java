package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.model.Cuisine;
import com.fhsbatista.fooddelivery.domain.model.Restaurant;
import com.fhsbatista.fooddelivery.domain.repository.CuisineRepository;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class AddCuisineMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(
                FooddeliveryApplication.class
        ).web(WebApplicationType.NONE).run(args);

        final var registerCuisine = applicationContext.getBean(CuisineRepository.class);
        final var registerRestaurant = applicationContext.getBean(RestaurantRepository.class);

        final var cuisine1 = new Cuisine();
        cuisine1.setName("brazilian");
        final var cuisine2 = new Cuisine();
        cuisine2.setName("peruvian");

        final var restaurant1 = new Restaurant();
        restaurant1.setName("los soles");

        registerCuisine.save(cuisine1);
        registerCuisine.save(cuisine2);
        registerRestaurant.save(restaurant1);
        registerRestaurant.save(restaurant1);
    }
}
