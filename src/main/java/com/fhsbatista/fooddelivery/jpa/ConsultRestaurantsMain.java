package com.fhsbatista.fooddelivery.jpa;

import com.fhsbatista.fooddelivery.FooddeliveryApplication;
import com.fhsbatista.fooddelivery.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class ConsultRestaurantsMain {
    public static void main(String[] args) {
        final var context = new SpringApplicationBuilder(FooddeliveryApplication.class).web(WebApplicationType.NONE).run();

        final var registerRestaurant = context.getBean(RestaurantRepository.class);
        final var restaurants = registerRestaurant.findAll();

        restaurants.forEach(r -> {
            System.out.printf("%s - %f - %s\n", r.getName(), r.getDeliveryTax(), r.getCuisine().getName());
        });
    }
}
